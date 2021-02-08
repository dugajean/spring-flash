package dev.dougman.springflash.templates;

import dev.dougman.springflash.enums.Search;

import java.util.Map;

public class RepositoryTemplate implements Template {
    @Override
    public String get(Map<Search, String> map) {
        return """
package %1$s;

import org.springframework.data.jpa.repository.JpaRepository;

public interface %2$sRepository extends JpaRepository<%2$s, Long> {}
        
        """.formatted(
            map.get(Search.PACKAGE),
            map.get(Search.ENTITY_STUDLY_SINGULAR)
        );
    }
}
