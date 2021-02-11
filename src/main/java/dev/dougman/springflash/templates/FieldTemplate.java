package dev.dougman.springflash.templates;

import dev.dougman.springflash.enums.Search;

import java.util.List;
import java.util.Map;

public class FieldTemplate implements Template {
    public final List<Search> searchFields = List.of(Search.FIELD_TYPE, Search.FIELD_NAME_LOWER);

    @Override
    public String get(Map<Search, String> map) {
        return """
    private %s %s;
        """.formatted(
            map.get(searchFields.get(0)),
            map.get(searchFields.get(1))
        );
    }
}
