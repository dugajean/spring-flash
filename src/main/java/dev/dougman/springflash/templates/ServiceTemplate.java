package dev.dougman.springflash.templates;

import dev.dougman.springflash.enums.Search;

import java.util.Map;

public class ServiceTemplate implements Template {
    @Override
    public String get(Map<Search, String> map) {
        return """
package %1$s;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class %2$sService {
    @Autowired
    private %2$sRepository %3$sRepository;
}

        """.formatted(
            map.get(Search.PACKAGE),
            map.get(Search.ENTITY_STUDLY_SINGULAR),
            map.get(Search.ENTITY_LOWER_SINGULAR)
        );
    }
}
