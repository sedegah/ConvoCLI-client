package io.convocli.client;

import info.picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
        CommandLine.run(new CLI(), args);
    }
}
