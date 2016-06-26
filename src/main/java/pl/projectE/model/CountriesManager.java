package pl.projectE.model;

import pl.projectE.inject.Component;
import pl.projectE.inject.PostConstruct;
import pl.projectE.inject.qualifiers.CountriesNames;
import pl.projectE.inject.qualifiers.Implementation;
import pl.projectE.loaders.CountriesNamesLoader;
import pl.projectE.loaders.ResourceLoader;

import javax.inject.Inject;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@CountriesNames
public class CountriesManager {
    private Map<Country, Object> countries;
    @Inject
    @CountriesNames
    @Implementation(specifiedClass = CountriesNamesLoader.class)
    public ResourceLoader loader;

    @PostConstruct
    void init() {
        countries = loader.loadResource().stream().map(Country::new).collect(Collectors.groupingBy(Function.identity(), null));
    }
}
