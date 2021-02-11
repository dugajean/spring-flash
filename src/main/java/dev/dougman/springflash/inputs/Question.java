package dev.dougman.springflash.inputs;

public class Question implements Askable {
    private String question;

    public Question(String question) {
        this.question = question;
    }

    public String ask() {
        return System.console().readLine(question + ": ");
    }
}
