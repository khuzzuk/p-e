package pl.projectE.cache;

import org.apache.commons.collections4.map.MultiKeyMap;
import pl.projectE.inject.Component;
import pl.projectE.inject.qualifiers.*;
import pl.projectE.loaders.CountriesNamesLoader;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@Component
public class CacheInitializer {
    @Inject
    @CountriesNames
    @Implementation(specifiedClass = CountriesNamesLoader.class)
    private CountriesNamesLoader countriesNamesLoader;

    @PostConstruct
    public void initialize() {
        variablesKeys();
        loadCountriesNames();
    }

    @Component
    @CacheElement
    @KeyElements
    @Variables
    private MultiKeyMap<Object, String> variablesKeys() {
        return new MultiKeyMap<>();
    }

    @Component
    @CountriesNames
    private List<String> loadCountriesNames() {
        return countriesNamesLoader.loadResource();
    }
}
