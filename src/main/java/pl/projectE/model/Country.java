package pl.projectE.model;

import pl.projectE.loaders.GameStaticsLoader;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Country {
    private Map<Country, Object> countries;

    private String name;
    void init(GameStaticsLoader loader){
        countries = loader.loadCountries().stream().map(Country::new).collect(Collectors.groupingBy(Function.identity(), null));
    }

    public Country(String name) {
        this.name = name;
    }
}
