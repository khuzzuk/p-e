package pl.projectE.loaders;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.projectE.model.Country;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ScenarioLoader {
    @NonNull
    private ScenarioToArrayLoader rawDataLoader;
    @NonNull
    private CountriesNamesLoader countriesNamesLoader;
    private List<String> countriesNames;
    public SortedMap<String, Country> countries;

    public void loadScenario() {
        loadCountriesNames();
        prepareCountries(countriesNames);
        parseScenario(rawDataLoader.loadResource(), countries, countriesNames);
    }

    private void loadCountriesNames() {
        countriesNames = countriesNamesLoader.loadResource();
    }

    private void prepareCountries(List<String> countriesNames) {
        countries = new TreeMap<>();
        countriesNames.forEach(s -> countries.put(s, new Country(s)));
    }

    private void parseScenario(String[][] rawData, Map<String, Country> countries, List<String> countriesNames) {
        Country country;
        for (int x = 1; x < rawData[0].length; x++) {
            country = countries.get(countriesNames.get(x - 1));
            DeterminantsLoader.setCountryDeterminants(rawData, country, x);
            GovernmentActionsLoader.loadGovernmentActions(country, rawData, x);
        }
    }
}
