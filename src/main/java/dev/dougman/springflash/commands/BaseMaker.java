package dev.dougman.springflash.commands;

import dev.dougman.springflash.enums.Search;
import dev.dougman.springflash.utils.IoUtils;
import dev.dougman.springflash.utils.StringUtils;
import org.atteo.evo.inflector.English;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Callable;

@Command()
public abstract class BaseMaker implements Callable<Integer> {
    @Parameters(arity = "1", paramLabel = "<name>", description = "The name of the entity to create")
    protected String name;

    @Option(names = {"-p", "--package"}, description = "Path to main package", interactive = true)
    protected String pkg = "";

    /**
     * Get the stub content.
     */
    protected abstract String getStub();

    /**
     * Simple indicator as to what we're creating.
     */
    protected String getTarget() {
        return this.getClass().getSimpleName().replaceAll("Maker", "").toLowerCase();
    }

    /**
     * Search-Replace keywords used in stubs.
     */
    protected Map<Search, String> searchReplaceMap() {
        return Map.of(
            Search.PACKAGE, pkg.replace(File.separator, "."),
            Search.ENTITY_STUDLY_SINGULAR, StringUtils.convertToStartCase(name),
            Search.ENTITY_LOWER_SINGULAR, name.toLowerCase(),
            Search.ENTITY_LOWER_PLURAL, English.plural(name.toLowerCase())
        );
    }

    /**
     * Base execution logic for making new components.
     *
     * @throws IOException
     */
    @Override
    public Integer call() throws IOException {
        pkg = pkg.toLowerCase();
        name = StringUtils.convertToStartCase(name);

        if (!IoUtils.createFile(IoUtils.computePath(pkg, English.plural(getTarget()), name), getStub())) {
            return 1;
        }

        IoUtils.printSuccess("Successfully created %s \"%s\"".formatted(English.plural(getTarget(), 1), name));

        return 0;
    }
}