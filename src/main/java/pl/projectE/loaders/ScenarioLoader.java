package pl.projectE.loaders;

import lombok.RequiredArgsConstructor;
import pl.projectE.model.Country;
import pl.projectE.model.Scenario;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

@RequiredArgsConstructor
public class ScenarioLoader {
    private final DataToArrayLoader rawDataLoader;
    private final FileLinker countriesNamesData;
    private final FileLinker productsData;
    private final FileLinker prodMatrixData;
    private List<String> countriesNames;
    private List<String> productNames;

    public Scenario loadScenario() {
        countriesNames = new EnumeratedNamesLoader(countriesNamesData).loadResource();
        productNames = new EnumeratedNamesLoader(productsData).loadResource();
        String[][] rawData = rawDataLoader.loadResource();
        String[][] prodData = new DataToArrayLoader(prodMatrixData).loadResource();
        Scenario scenario = new Scenario();
        scenario.countries = parseScenario(rawData, prodData, prepareCountries(countriesNames), countriesNames, productNames);
        scenario.currencies = CurrencyLoader.loadCurrencies(rawData);
        return scenario;
    }

    private SortedMap<String, Country> prepareCountries(List<String> countriesNames) {
        SortedMap<String, Country> countries = new TreeMap<>();
        countriesNames.forEach(s -> countries.put(s, new Country(s)));
        return countries;
    }

    private SortedMap<String, Country> parseScenario(String[][] rawData, String[][] prodData, SortedMap<String, Country> countries, List<String> countriesNames, List<String> productNames) {
        Country country;
        for (int x = 1; x < rawData[0].length; x++) {
            country = countries.get(countriesNames.get(x - 1));
            DeterminantsLoader.setCountryDeterminants(rawData, prodData, country, x, productNames);
            GovernmentActionsLoader.loadGovernmentActions(country, rawData, x);
        }
        return countries;
    }
}
