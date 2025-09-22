package io.convocli.client;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.*;

@Command(name="convocli", mixinStandardHelpOptions=true, version="ConvoCLI 0.1",
         subcommands = { Signup.class, Login.class, Send.class, Inbox.class })
public class CLI implements Callable<Integer> {
    public Integer call() throws Exception {
        System.out.println("ConvoCLI - use subcommands: signup, login, send, inbox");
        return 0;
    }
}
