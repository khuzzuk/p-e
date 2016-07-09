package pl.projectE.loaders;

import pl.projectE.inject.Component;
import pl.projectE.inject.qualifiers.CountriesNames;
import pl.projectE.inject.qualifiers.Scenario;
import pl.projectE.model.Country;
import pl.projectE.model.economy.Assets;
import pl.projectE.model.economy.MacroIndicators;
import pl.projectE.model.government.GovernmentFinances;
import pl.projectE.model.government.Military;
import pl.projectE.model.land.ImprovementsToLand;
import pl.projectE.model.land.Infrastructure;
import pl.projectE.model.land.InfrastructureTechnology;
import pl.projectE.model.social.CivilSecurity;
import pl.projectE.model.social.HealthCare;
import pl.projectE.model.social.SocialIndicators;
import pl.projectE.model.social.Technology;
import pl.projectE.sec.Privileged;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static pl.projectE.loaders.FileVars.*;

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
            DeterminantsLoader.setCountryDeterminants(rawData, country, x);
        }
    }

    public Map<String, Country> getCountries() {
        return countries;
    }

    private static class DeterminantsLoader{
        @Privileged
        private static void setCountryDeterminants(@NotNull String[][] rawData, Country country, int x) {
            country.assets = createAssets(rawData, x);
            country.macroIndicators = createMacroIndicators(rawData, x);
            country.military = createMilitary(rawData, x);
            country.improvementsToLand = createImprovementsToLand(rawData, x);
            country.infrastructure = createInfrastructure(rawData, x);
            country.infrastructureTechnology = createInfrastructureTechnology(rawData, x);
            country.socialIndicators = createSocialIndicators(rawData, x);
            country.civilSecurity = createCivilSecurity(rawData, x);
            country.healthCare = createHealthCare(rawData, x);
            country.technology = createTechnology(rawData, x);
            country.governmentFinances = createGovernmentFinances(rawData, x);
        }

        @Privileged
        @NotNull
        private static Technology createTechnology(@NotNull String[][] rawData, int column) {
            Technology technology = new Technology();
            technology.techNaturalResources = Integer.parseInt(rawData[techNaturalResources][column]);
            technology.techBiomedics = Integer.parseInt(rawData[techBiomedics][column]);
            technology.techEngineering = Integer.parseInt(rawData[techEngineering][column]);
            technology.techComputers = Integer.parseInt(rawData[techComputers][column]);
            technology.techMathematicsEconomy = Integer.parseInt(rawData[techMathematicsEconomy][column]);
            technology.techPhysics = Integer.parseInt(rawData[techPhysics][column]);
            technology.techSocialSciences = Integer.parseInt(rawData[techSocialSciences][column]);
            technology.techMilitary = Integer.parseInt(rawData[techMilitary][column]);
            technology.techHumanities = Integer.parseInt(rawData[techHumanities][column]);
            technology.techForeignLanguages = Integer.parseInt(rawData[techForeignLanguages][column]);
            technology.techArtistry = Integer.parseInt(rawData[techArtistry][column]);
            return technology;
        }

        @Privileged
        @NotNull
        private static CivilSecurity createCivilSecurity(@NotNull String[][] rawData, int column) {
            CivilSecurity security = new CivilSecurity();
            security.corruption = Integer.parseInt(rawData[corruption][column]);
            security.crimeRate = Integer.parseInt(rawData[crimeRate][column]);
            security.imprisonedPopulation = Integer.parseInt(rawData[imprisonedPopulation][column]);
            security.policeEquipmentCapital = Long.parseLong(rawData[policeEquipmentCapital][column]);
            return security;
        }

        @Privileged
        @NotNull
        private static SocialIndicators createSocialIndicators(@NotNull String[][] rawData, int column) {
            SocialIndicators indicators = new SocialIndicators();
            indicators.educatedPopulation = Integer.parseInt(rawData[educatedPopulation][column]);
            indicators.familyValues = Integer.parseInt(rawData[familyValues][column]);
            return indicators;
        }

        @Privileged
        @NotNull
        private static InfrastructureTechnology createInfrastructureTechnology(@NotNull String[][] rawData, int column) {
            InfrastructureTechnology infrastructure = new InfrastructureTechnology();
            infrastructure.roads = Integer.parseInt(rawData[roadsTech][column]);
            infrastructure.highways = Integer.parseInt(rawData[highwaysTech][column]);
            infrastructure.railways = Integer.parseInt(rawData[railwaysTech][column]);
            infrastructure.airports = Integer.parseInt(rawData[airportsTech][column]);
            infrastructure.docks = Integer.parseInt(rawData[docksTech][column]);
            infrastructure.vehicles = Integer.parseInt(rawData[vehiclesTech][column]);
            return infrastructure;
        }

        @Privileged
        @NotNull
        private static Infrastructure createInfrastructure(@NotNull String[][] rawData, int column) {
            Infrastructure infrastructure = new Infrastructure();
            infrastructure.roads = Integer.parseInt(rawData[roads][column]);
            infrastructure.highways = Integer.parseInt(rawData[highways][column]);
            infrastructure.railways = Integer.parseInt(rawData[railways][column]);
            infrastructure.airports = Integer.parseInt(rawData[airports][column]);
            infrastructure.docks = Integer.parseInt(rawData[docks][column]);
            infrastructure.vehicles = Integer.parseInt(rawData[vehicles][column]);
            return infrastructure;
        }

        @Privileged
        @NotNull
        private static ImprovementsToLand createImprovementsToLand(@NotNull String[][] rawData, int column) {
            ImprovementsToLand land = new ImprovementsToLand();
            land.housingUnits = Integer.parseInt(rawData[housingUnits][column]);
            return land;
        }

        @Privileged
        @NotNull
        private static GovernmentFinances createGovernmentFinances(@NotNull String[][] rawData, int column) {
            GovernmentFinances governmentFinances = new GovernmentFinances();
            governmentFinances.totalReceipts = Long.parseLong(rawData[totalGovReceipts][column]);
            return governmentFinances;
        }

        @Privileged
        @NotNull
        private static Military createMilitary(@NotNull String[][] rawData, int column) {
            Military military = new Military();
            military.equipmentCapital = Long.parseLong(rawData[militaryEquipmentCapital][column]);
            return military;
        }

        @Privileged
        @NotNull
        private static Assets createAssets(@NotNull String[][] rawData, int column) {
            Assets assets = new Assets();
            assets.pensionNetCapital = Long.parseLong(rawData[pensionNetCapital][column]);
            assets.nationalDebt = Long.parseLong(rawData[nationalDebt][column]);
            assets.assetsPrivate = Long.parseLong(rawData[assetsPrivate][column]);
            assets.assetsCorporate = Long.parseLong(rawData[assetsCorporate][column]);
            assets.stockMarketValue = Long.parseLong(rawData[stockMarketValue][column]);
            assets.m0 = Long.parseLong(rawData[m0][column]);
            return assets;
        }

        @Privileged
        @NotNull
        private static MacroIndicators createMacroIndicators(@NotNull String[][] rawData, int column) {
            MacroIndicators indicators = new MacroIndicators();
            indicators.inflation = Integer.parseInt(rawData[inflation][column]);
            indicators.debtInterestRate = Integer.parseInt(rawData[debtInterestRate][column]);
            indicators.averageSalary = Integer.parseInt(rawData[averageSalary][column]);
            indicators.cci = Integer.parseInt(rawData[cci][column]);
            indicators.gdp = Integer.parseInt(rawData[gdp][column]);
            indicators.investments = Integer.parseInt(rawData[investments][column]);
            indicators.netWages = Integer.parseInt(rawData[netWages][column]);
            return indicators;
        }

        @Privileged
        @NotNull
        private static HealthCare createHealthCare(@NotNull String[][] rawData, int column) {
            HealthCare healthCare = new HealthCare();
            healthCare.healthCondition = Integer.parseInt(rawData[healthCondition][column]);
            return healthCare;
        }
    }
}
