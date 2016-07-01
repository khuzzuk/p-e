package pl.projectE.model;

import pl.projectE.inject.Component;
import pl.projectE.inject.qualifiers.CountriesNames;
import pl.projectE.inject.qualifiers.Implementation;
import pl.projectE.loaders.CountriesNamesLoader;
import pl.projectE.loaders.ResourceLoader;
import pl.projectE.sec.LimitedAccess;
import pl.projectE.sec.Privileged;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@CountriesNames
class CountriesManager {
    @LimitedAccess
    Map<String, Country> countries;

    @Inject
    @CountriesNames
    @Implementation(specifiedClass = CountriesNamesLoader.class)
    ResourceLoader loader;

    @PostConstruct
    @Privileged
    private void init() {
        countries = loader.loadResource().stream().map(Country::new).collect(Collectors.toMap(Country::getName, c -> c));
    }
}
