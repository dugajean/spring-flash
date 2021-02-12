package dev.dougman.springflash.commands;

import dev.dougman.springflash.inputs.Askable;
import dev.dougman.springflash.enums.Search;
import dev.dougman.springflash.templates.Template;
import dev.dougman.springflash.utils.IoUtils;
import dev.dougman.springflash.utils.StringUtils;
import org.atteo.evo.inflector.English;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

@Command()
public abstract class BaseMaker implements Callable<Integer> {
    @Parameters(arity = "1", paramLabel = "<name>", description = "The name of the entity to create")
    protected String name;

    @Option(names = {"-p", "--package"}, description = "Path to main package", interactive = true)
    protected String packagePath = "";

    /**
     * Contains list of answers from the prompted questions.
     */
    protected String promptedAnswers = "";

    /**
     * Get the template we're baking.
     */
    protected abstract Template template();

    /**
     * Whether the instance of this maker will cause a prompt/ask questions.
     */
    protected final boolean isPromptable = this instanceof Promptable;

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
        var map = new HashMap<Search, String>();
        map.put(Search.PACKAGE, packagePath.replace(File.separator, "."));
        map.put(Search.ENTITY_STUDLY_SINGULAR, StringUtils.convertToStartCase(name));
        map.put(Search.ENTITY_LOWER_SINGULAR, name.toLowerCase());
        map.put(Search.ENTITY_LOWER_PLURAL, English.plural(name.toLowerCase()));

        if (isPromptable) {
            Promptable self = (Promptable) this;
            map.put(self.targetKey(), promptedAnswers);
        }

        return map;
    }

    /**
     * Trigger user questions if they're present.
     */
    protected void triggerPromptableMaker() {
        if (!isPromptable) {
            return;
        }

        Promptable self = (Promptable) this;
        Askable questions = self.prompt();

        promptedAnswers = questions.ask();
    }

    /**
     * Base execution logic for making new components.
     *
     * @throws IOException
     */
    @Override
    public Integer call() throws IOException {
        packagePath = packagePath.toLowerCase();
        name = StringUtils.convertToStartCase(name);
        Path path = IoUtils.computePath(packagePath.replaceAll("\\.", File.separator), English.plural(getTarget()), name);

        this.triggerPromptableMaker();

        if (!IoUtils.createFile(path, template().get(searchReplaceMap()))) {
            return 1;
        }

        IoUtils.printSuccess("Successfully created %s \"%s\"".formatted(English.plural(getTarget(), 1), name));

        return 0;
    }
}