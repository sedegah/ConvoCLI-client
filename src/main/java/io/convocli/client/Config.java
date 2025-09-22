package io.convocli.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.*;
import java.util.Map;

public class Config {
    private static final Path CFG = Path.of(System.getProperty("user.home"), ".convocli", "config.json");
    private static final ObjectMapper M = new ObjectMapper();

    public static void saveToken(String token, String server) throws Exception {
        Files.createDirectories(CFG.getParent());
        M.writeValue(CFG.toFile(), Map.of("token", token, "server", server));
    }

    public static Map<?,?> load() throws Exception {
        if (!Files.exists(CFG)) return null;
        return M.readValue(CFG.toFile(), Map.class);
    }
}
