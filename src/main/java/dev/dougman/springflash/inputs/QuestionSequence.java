package dev.dougman.springflash.inputs;

import dev.dougman.springflash.enums.Search;
import dev.dougman.springflash.templates.Template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionSequence implements Askable {
    /**
     * The target template that the user's answers will be glued into.
     */
    private final Template template;

    /**
     * List of questions to present to the user.
     */
    private final List<Question> questions;

    /**
     * Template keys that will be searched and replaced in the template.
     */
    private final List<Search> templateKeys;

    /**
     * Constructor.
     */
    public QuestionSequence(Map<Search, Question> questionsMap, Template template) {
        this.questions = new ArrayList<>(questionsMap.values());
        this.templateKeys = new ArrayList<>(questionsMap.keySet());
        this.template = template;
    }

    /**
     * Ask sequence of questions indefinitely until the user explicitly stops and replace them in the provided template.
     */
     public String ask() {
        String answer = ".";

        int i = 0;
        var answers = new ArrayList<String>();
        var currentMap = new HashMap<Search, String>();

        while (!answer.isEmpty()) {
            answer = questions.get(i).ask();
            currentMap.put(templateKeys.get(i), answer);
            i++;

            if (i >= questions.size()){
                answers.add(template.get(currentMap));
                currentMap = new HashMap<Search, String>();
                i = 0;
            }
        }

        return String.join("\n\t", answers);
    }
}
