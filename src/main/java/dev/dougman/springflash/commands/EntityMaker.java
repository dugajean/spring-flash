package dev.dougman.springflash.commands;

import dev.dougman.springflash.inputs.Askable;
import dev.dougman.springflash.inputs.Question;
import dev.dougman.springflash.enums.Search;
import dev.dougman.springflash.inputs.QuestionSequence;
import dev.dougman.springflash.templates.EntityTemplate;
import dev.dougman.springflash.templates.FieldTemplate;
import picocli.CommandLine.Command;

import java.util.Map;

@Command(name = "make:entity", description = "Generate a entity stub.")
public class EntityMaker extends BaseMaker implements Promptable {
    @Override
    protected EntityTemplate template() {
        return new EntityTemplate();
    }

    @Override
    public Askable prompt() {
        Map<Search, Question> questionsMap = Map.of(
            Search.FIELD_NAME_LOWER, new Question("Field name"),
            Search.FIELD_TYPE, new Question("Field type (String, boolean, int, float, etc.)")
        );

        return new QuestionSequence(questionsMap, new FieldTemplate());
    }

    @Override
    public Search targetKey() {
        return Search.ENTITY_FIELDS;
    }
}
