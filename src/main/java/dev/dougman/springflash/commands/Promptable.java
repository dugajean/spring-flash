package dev.dougman.springflash.commands;

import dev.dougman.springflash.enums.Search;
import dev.dougman.springflash.inputs.Askable;

public interface Promptable {
    /**
     * Setup Askables that will prompt for user input.
     */
    public Askable prompt();

    /**
     * Search key that will be replaced in the template.
     */
    public Search targetKey();
}
