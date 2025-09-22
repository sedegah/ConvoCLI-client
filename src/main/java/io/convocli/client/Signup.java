package io.convocli.client;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import okhttp3.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

@Command(name="signup", description="Create account and save token")
public class Signup implements Runnable {
    @Option(names="--server", required=true) String server;
    @Option(names="--username", required=true) String username;
    @Option(names="--password", required=true) String password;

    public void run() {
        try {
            OkHttpClient c = new OkHttpClient();
            ObjectMapper m = new ObjectMapper();
            RequestBody body = RequestBody.create(m.writeValueAsString(Map.of("username",username,"password",password)), MediaType.get("application/json"));
            Request req = new Request.Builder().url(server+"/auth/signup").post(body).build();
            try (Response resp = c.newCall(req).execute()) {
                if (!resp.isSuccessful()) { System.err.println("Signup failed: "+resp.code()+" "+resp.body().string()); return; }
                Map map = m.readValue(resp.body().string(), Map.class);
                String token = (String) map.get("token");
                Config.saveToken(token, server);
                System.out.println("Signed up and saved token.");
            }
        } catch (Exception ex) { ex.printStackTrace(); }
    }
}
