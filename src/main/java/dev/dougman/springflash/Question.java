package dev.dougman.springflash;

import dev.dougman.springflash.templates.Template;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private final String question;
    private final List<String> questions;

    private String answer;
    private List<List<String>> answers = new ArrayList<>();

    public Question(String question) {
        this.question = question;
        this.questions = new ArrayList<>();
    }

    public Question(List<String> questions) {
        this.question = "";
        this.questions = questions;
    }

    public String ask() {
        if (!question.isEmpty()) {
            answer = System.console().readLine(question + " ");
            return answer;
        }

        int i = 0;
        List<String> currentList = new ArrayList<String>();

        while (true) {
            if (i >= questions.size()){
                i = 0;
            }

            String answer = System.console().readLine(questions.get(i) + " [ENTER again to quit] ");

            if (answer.isEmpty()) {
                break;
            }

            if (i < questions.size()) {
                if (i == 0) {
                    currentList = new ArrayList<String>();
                }

                currentList.add(answer);
                i++;
            }

            answers.add(currentList);
        }

        System.out.println(answers);

        return "";
    }
}
