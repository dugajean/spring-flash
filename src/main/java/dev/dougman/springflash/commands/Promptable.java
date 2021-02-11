package dev.dougman.springflash.commands;

import dev.dougman.springflash.enums.Search;
import dev.dougman.springflash.inputs.Askable;

public interface Promptable {
    public Askable prompt();
    public Search targetKey();
}
