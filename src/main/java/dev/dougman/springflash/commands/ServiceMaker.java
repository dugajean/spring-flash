package dev.dougman.springflash.commands;

import dev.dougman.springflash.templates.ServiceTemplate;
import picocli.CommandLine.Command;

@Command(name = "make:service", description = "Generate a service stub.")
public class ServiceMaker extends BaseMaker {
    @Override
    protected ServiceTemplate template() {
        return new ServiceTemplate();
    }
}
