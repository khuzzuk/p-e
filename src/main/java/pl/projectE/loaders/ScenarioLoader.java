package pl.projectE.loaders;

import pl.projectE.inject.Component;
import pl.projectE.inject.qualifiers.CountriesNames;
import pl.projectE.inject.qualifiers.Scenario;
import pl.projectE.model.Country;
import pl.projectE.model.economy.Assets;
import pl.projectE.sec.Privileged;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Scenario
public class ScenarioLoader {
    @Inject
    @Scenario
    private ScenarioToArrayLoader rawDataLoader;

    @Inject
    @CountriesNames
    private CountriesNamesLoader countriesNamesLoader;

    private List<String> countriesNames;
    private Map<String, Country> countries;

    public void loadScenario() {
        loadCountriesNames();
        prepareCountries(countriesNames);
        parseScenario(rawDataLoader.loadResource(), countries, countriesNames);
    }

    @Component
    @Named("countriesNamesList")
    @CountriesNames
    private void loadCountriesNames() {
        countriesNames = countriesNamesLoader.loadResource();
    }

    private void prepareCountries(@NotNull List<String> countriesNames) {
        countries = countriesNames.stream().collect(Collectors.toMap(s -> s, Country::new));
    }

    private void parseScenario(@NotNull String[][] rawData, @NotNull Map<String, Country> countries, @NotNull List<String> countriesNames) {
        Country country;
        for (int x = 1; x < rawData[0].length; x++) {
            country = countries.get(countriesNames.get(x - 1));
            country.setAssets(prepareAssets(rawData, x));
        }
    }

    @Privileged
    private Assets prepareAssets(@NotNull String[][] rawData, int column) {
        Assets assets = new Assets();
        assets.pensionNetCapital = Long.parseLong(rawData[1][column]);
        assets.nationalDebt = Long.parseLong(rawData[2][column]);
        assets.assetsPrivate = Long.parseLong(rawData[3][column]);
        assets.assetsCorporate = Long.parseLong(rawData[4][column]);
        assets.stockMarketValue = Long.parseLong(rawData[5][column]);
        assets.m0 = Long.parseLong(rawData[6][column]);
        return assets;
    }

    public Map<String, Country> getCountries() {
        return countries;
    }
}
