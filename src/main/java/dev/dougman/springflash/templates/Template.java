package dev.dougman.springflash.templates;

import dev.dougman.springflash.enums.Search;

import java.util.Map;

public interface Template {
    public String get(Map<Search, String> map);
}
