package dev.dougman.springflash.templates;

import dev.dougman.springflash.enums.Search;

import java.util.List;
import java.util.Map;

public class FieldTemplate implements Template {
    @Override
    public String get(Map<Search, String> map) {
        return """
    private %s %s;
        """.formatted(
            map.get(Search.FIELD_TYPE),
            map.get(Search.FIELD_NAME_LOWER)
        );
    }
}
