package dev.dougman.springflash;

import picocli.CommandLine;

public class Main {
    public static void main(String... args) {
        System.exit(new CommandLine(new Flash()).execute(args));
    }
}
