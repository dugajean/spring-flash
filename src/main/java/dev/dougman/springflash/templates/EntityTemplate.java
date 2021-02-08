package dev.dougman.springflash.templates;

import dev.dougman.springflash.enums.Search;

import java.util.Map;

public class EntityTemplate implements Template {
    @Override
    public String get(Map<Search, String> map) {
        return """
package %1$s;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class %2$s {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}

        """.formatted(
            map.get(Search.PACKAGE),
            map.get(Search.ENTITY_STUDLY_SINGULAR)
        );
    }
}
