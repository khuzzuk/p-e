package pl.projectE.model;

import pl.projectE.inject.Component;
import pl.projectE.inject.qualifiers.CountriesNames;
import pl.projectE.loaders.CountriesNamesLoader;
import pl.projectE.sec.LimitedAccess;
import pl.projectE.sec.Privileged;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Map;

@Component
@CountriesNames
class CountriesManager {
    @LimitedAccess
    Map<String, Country> countries;

    @Inject
    @CountriesNames
    CountriesNamesLoader loader;

    @PostConstruct
    @Privileged
    private void init() {
    }
}
