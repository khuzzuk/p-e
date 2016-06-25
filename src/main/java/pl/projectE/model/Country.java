package pl.projectE.model;

import pl.projectE.inject.Component;
import pl.projectE.inject.CountriesNames;
import pl.projectE.inject.PostConstruct;
import pl.projectE.loaders.CountriesNamesLoader;
import pl.projectE.loaders.ResourceLoader;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@PostConstruct(methods = "init")
public class Country {
    static Map<Country, Object> countries;
    @Inject
    @CountriesNames
    public static CountriesNamesLoader loader;

    private String name;

    void init() {
        countries = loader.loadResource().stream().map(Country::new).collect(Collectors.groupingBy(Function.identity(), null));
    }

    public Country(String name) {
        this.name = name;
    }
}
