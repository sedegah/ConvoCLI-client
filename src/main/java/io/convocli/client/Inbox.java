package io.convocli.client;

import picocli.CommandLine.*;
import okhttp3.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;

@Command(name="inbox", description="Fetch message history with a user (last 30 days).")
public class Inbox implements Runnable {
    @Option(names="--with", required=true) String withUser;
    public void run() {
        try {
            Map cfg = (Map) Config.load();
            if (cfg==null) { System.err.println("Not logged in."); return; }
            String token = (String) cfg.get("token");
            String server = (String) cfg.get("server");
            OkHttpClient c = new OkHttpClient();
            Request req = new Request.Builder().url(server + "/messages/history?withUser=" + withUser)
                    .addHeader("Authorization", "Bearer " + token)
                    .build();
            try (Response resp = c.newCall(req).execute()) {
                if (!resp.isSuccessful()) { System.err.println("Failed: " + resp.code()); return; }
                ObjectMapper m = new ObjectMapper();
                List list = m.readValue(resp.body().string(), List.class);
                for (Object o : list) {
                    Map msg = (Map) o;
                    System.out.printf("[%s] %s -> %s: %s\n", msg.get("createdAt"), msg.get("sender"), msg.get("receiver"), msg.get("content"));
                }
            }
        } catch (Exception ex) { ex.printStackTrace(); }
    }
}
