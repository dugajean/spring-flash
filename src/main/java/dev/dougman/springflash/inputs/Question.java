package dev.dougman.springflash.inputs;

public class Question implements Askable {
    /**
     * The question that the app will ask.
     */
    private String question;

    /**
     * Question constructor.
     *
     * @param question The question being asked.
     */
    public Question(String question) {
        this.question = question;
    }

    /**
     * Ask the single question.
     */
    public String ask() {
        return System.console().readLine(question + ": ");
    }
}
