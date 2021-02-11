package dev.dougman.springflash.templates;

import dev.dougman.springflash.enums.Search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface Template {
    public List<Search> searchFields = new ArrayList<>();
    public String get(Map<Search, String> map);
}
