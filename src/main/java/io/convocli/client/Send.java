package io.convocli.client;

import picocli.CommandLine.*;
import okhttp3.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Command(name="send", description="Send a message to a user (real-time).")
public class Send implements Runnable {
    @Option(names="--to", required=true) String to;
    @Option(names="--message", required=true) String message;
    public void run() {
        try {
            Map cfg = (Map) Config.load();
            if (cfg==null) { System.err.println("Not logged in. Use login or signup."); return; }
            String token = (String) cfg.get("token");
            String server = (String) cfg.get("server");
            OkHttpClient client = new OkHttpClient.Builder().readTimeout(0, TimeUnit.MILLISECONDS).build();
            Request req = new Request.Builder().url(server.replaceFirst("^http", "ws") + "/ws/chat")
                    .addHeader("Authorization", "Bearer " + token)
                    .build();
            WebSocketListener listener = new WebSocketListener() {
                @Override
                public void onOpen(WebSocket webSocket, Response response) {
                    try {
                        ObjectMapper m = new ObjectMapper();
                        String payload = m.writeValueAsString(Map.of("to", to, "content", message));
                        webSocket.send(payload);
                        webSocket.close(1000, "bye");
                    } catch (Exception e) { e.printStackTrace(); }
                }
                @Override
                public void onMessage(WebSocket webSocket, String text) {
                    System.out.println("RECV: " + text);
                }
                @Override
                public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                    System.err.println("WS failure: " + t.getMessage());
                }
            };
            client.newWebSocket(req, listener);
            Thread.sleep(800);
        } catch (Exception ex) { ex.printStackTrace(); }
    }
}
