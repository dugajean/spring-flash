package dev.dougman.springflash.commands;

import dev.dougman.springflash.Promptable;
import dev.dougman.springflash.Question;
import dev.dougman.springflash.templates.EntityTemplate;
import picocli.CommandLine.Command;

import java.util.List;

@Command(name = "make:entity", description = "Generate a entity stub.")
public class EntityMaker extends BaseMaker implements Promptable {
    @Override
    protected EntityTemplate template() {
        return new EntityTemplate();
    }

    @Override
    public Question prompt() {
        return new Question(List.of("How old are you, boi?", "How old are you, son?"));
    }
}
