package dev.dougman.springflash.commands;

import dev.dougman.springflash.templates.ControllerTemplate;
import picocli.CommandLine.Command;

@Command(name = "make:controller", description = "Generate a controller stub.")
public class ControllerMaker extends BaseMaker {
    @Override
    protected ControllerTemplate template() {
        return new ControllerTemplate();
    }
}
