package dev.dougman.springflash.commands;

import dev.dougman.springflash.templates.EntityTemplate;
import picocli.CommandLine.Command;

@Command(name = "make:entity", description = "Generate a entity stub.")
public class EntityMaker extends BaseMaker {
    @Override
    protected String getStub() {
        return new EntityTemplate().get(searchReplaceMap());
    }
}
