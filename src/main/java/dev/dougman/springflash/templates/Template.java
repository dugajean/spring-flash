package dev.dougman.springflash.templates;

import dev.dougman.springflash.enums.Search;

import java.util.Map;

public interface Template {
    /**
     * Fetch the template string.
     *
     * @param map The map of search-replacements to be performed on the template string.
     */
    public String get(Map<Search, String> map);
}
