package pl.projectE.model;

import pl.projectE.inject.Component;
import pl.projectE.inject.qualifiers.CountriesNames;
import pl.projectE.inject.PostConstruct;
import pl.projectE.loaders.CountriesNamesLoader;

import javax.inject.Inject;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Country {
    static Map<Country, Object> countries;

    private String name;

    public Country(String name) {
        this.name = name;
    }
}
