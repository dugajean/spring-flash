package dev.dougman.springflash;

import dev.dougman.springflash.commands.ControllerMaker;
import dev.dougman.springflash.commands.EntityMaker;
import dev.dougman.springflash.commands.RepositoryMaker;
import dev.dougman.springflash.commands.ServiceMaker;
import picocli.CommandLine.Command;

@Command(
    name = "Spring Flash",
    version = "0.1",
    mixinStandardHelpOptions = true,
    subcommands = {
        EntityMaker.class,
        ControllerMaker.class,
        RepositoryMaker.class,
        ServiceMaker.class
    }
)
class Flash {}