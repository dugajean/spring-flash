package dev.dougman.springflash.templates;

import dev.dougman.springflash.enums.Search;

import java.util.Map;

public class ControllerTemplate implements Template {
    @Override
    public String get(Map<Search, String> map) {
        return """
package %1$s;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/%2$s")
public class %3$sController {
    private final %3$sService %4$sService;
    private final ModelMapper modelMapper;

    public %3$sController(%3$sService %4$sService, ModelMapper modelMapper) {
        this.%4$sService = %4$sService;
        this.modelMapper = modelMapper;
    }
}

        """.formatted(
            map.get(Search.PACKAGE),
            map.get(Search.ENTITY_LOWER_PLURAL),
            map.get(Search.ENTITY_STUDLY_SINGULAR),
            map.get(Search.ENTITY_LOWER_SINGULAR)
        );
    }
}
