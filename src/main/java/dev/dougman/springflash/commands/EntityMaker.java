package dev.dougman.springflash.commands;

import dev.dougman.springflash.templates.EntityTemplate;
import picocli.CommandLine.Command;

@Command(name = "make:entity", description = "Generate a entity stub.")
public class EntityMaker extends BaseMaker {
    @Override
    protected EntityTemplate template() {
        return new EntityTemplate();
    }
}
