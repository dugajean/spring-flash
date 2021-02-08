package dev.dougman.springflash.commands;

import dev.dougman.springflash.templates.RepositoryTemplate;
import picocli.CommandLine.Command;

@Command(name = "make:repository", description = "Generate a repository stub.")
public class RepositoryMaker extends BaseMaker {
    @Override
    protected String getStub() {
        return new RepositoryTemplate().get(searchReplaceMap());
    }
}
