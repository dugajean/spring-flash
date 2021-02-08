package dev.dougman.springflash.commands;

import dev.dougman.springflash.templates.ServiceTemplate;
import picocli.CommandLine.Command;

@Command(name = "make:service", description = "Generate a service stub.")
public class ServiceMaker extends BaseMaker {
    @Override
    protected String getStub() {
        return new ServiceTemplate().get(searchReplaceMap());
    }
}
