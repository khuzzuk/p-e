package pl.projectE.loaders;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.projectE.model.Country;

import java.util.*;

@RequiredArgsConstructor
public class ScenarioLoader {
    private final ScenarioToArrayLoader rawDataLoader;
    private final FileLinker countriesNamesData;
    private final FileLinker productsData;
    private List<String> countriesNames;
    private List<String> productNames;
    public SortedMap<String, Country> countries;

    public void loadScenario() {
        countriesNames = new EnumeratedNamesLoader(countriesNamesData).loadResource();
        productNames = new EnumeratedNamesLoader(productsData).loadResource();
        prepareCountries(countriesNames);
        parseScenario(rawDataLoader.loadResource(), countries, countriesNames, productNames);
    }

    private void prepareCountries(List<String> countriesNames) {
        countries = new TreeMap<>();
        countriesNames.forEach(s -> countries.put(s, new Country(s)));
    }

    private void parseScenario(String[][] rawData, Map<String, Country> countries, List<String> countriesNames, List<String> productNames) {
        Country country;
        for (int x = 1; x < rawData[0].length; x++) {
            country = countries.get(countriesNames.get(x - 1));
            DeterminantsLoader.setCountryDeterminants(rawData, country, x, productNames);
            GovernmentActionsLoader.loadGovernmentActions(country, rawData, x);
        }
    }
}
