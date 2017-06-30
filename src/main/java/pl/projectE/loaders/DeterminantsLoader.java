package pl.projectE.loaders;

import lombok.experimental.UtilityClass;
import pl.projectE.model.Country;
import pl.projectE.model.demography.Population;
import pl.projectE.model.economy.Assets;
import pl.projectE.model.economy.MacroIndicators;
import pl.projectE.model.government.GovernmentFinances;
import pl.projectE.model.government.Military;
import pl.projectE.model.land.*;
import pl.projectE.model.production.Product;
import pl.projectE.model.social.CivilSecurity;
import pl.projectE.model.social.HealthCare;
import pl.projectE.model.social.SocialIndicators;
import pl.projectE.model.social.Technology;

import java.util.List;

import static pl.projectE.loaders.FileVars.*;
import static pl.projectE.loaders.LoadersUtil.loadInt;
import static pl.projectE.loaders.LoadersUtil.loadLong;

@UtilityClass
class DeterminantsLoader {
    public static List<String> productNames;
    static void setCountryDeterminants(String[][] rawData, Country country, int x, List<String> productNames) {
        country.assets = loadAssets(rawData, x);
        country.macroIndicators = loadMacroIndicators(rawData, x);
        country.military = loadMilitary(rawData, x);
        country.land = loadLand(rawData, x);
        country.socialIndicators = loadSocialIndicators(rawData, x);
        country.civilSecurity = loadCivilSecurity(rawData, x);
        country.healthCare = loadHealthCare(rawData, x);
        country.technology = loadTechnology(rawData, x);
        country.governmentFinances = loadGovernmentFinances(rawData, x);
        country.population = loadPopulation(rawData, x);
        country.products = loadProducts(rawData, x, productNames);
    }

    private static Technology loadTechnology(String[][] rawData, int column) {
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

    private static CivilSecurity loadCivilSecurity(String[][] rawData, int column) {
        CivilSecurity security = new CivilSecurity();
        security.corruption = Integer.parseInt(rawData[corruption][column]);
        security.crimeRate = Integer.parseInt(rawData[crimeRate][column]);
        security.imprisonedPopulation = Integer.parseInt(rawData[imprisonedPopulation][column]);
        security.policeEquipmentCapital = Long.parseLong(rawData[policeEquipmentCapital][column]);
        return security;
    }

    private static SocialIndicators loadSocialIndicators(String[][] rawData, int column) {
        SocialIndicators indicators = new SocialIndicators();
        indicators.educatedPopulation = Integer.parseInt(rawData[educatedPopulation][column]);
        indicators.familyValues = Integer.parseInt(rawData[familyValues][column]);
        indicators.familyAllowancesPerChild = loadInt(rawData[socFamilyAllowancesPerChild][column]);
        return indicators;
    }

    private static InfrastructureTechnology loadInfrastructureTechnology(String[][] rawData, int column) {
        InfrastructureTechnology infrastructure = new InfrastructureTechnology();
        infrastructure.roads = Integer.parseInt(rawData[roadsTech][column]);
        infrastructure.highways = Integer.parseInt(rawData[highwaysTech][column]);
        infrastructure.railways = Integer.parseInt(rawData[railwaysTech][column]);
        infrastructure.airports = Integer.parseInt(rawData[airportsTech][column]);
        infrastructure.docks = Integer.parseInt(rawData[docksTech][column]);
        infrastructure.vehicles = Integer.parseInt(rawData[vehiclesTech][column]);
        return infrastructure;
    }

    private static Infrastructure loadInfrastructure(String[][] rawData, int column) {
        Infrastructure infrastructure = new Infrastructure();
        infrastructure.roads = Integer.parseInt(rawData[roads][column]);
        infrastructure.highways = Integer.parseInt(rawData[highways][column]);
        infrastructure.railways = Integer.parseInt(rawData[railways][column]);
        infrastructure.airports = Integer.parseInt(rawData[airports][column]);
        infrastructure.docks = Integer.parseInt(rawData[docks][column]);
        infrastructure.vehicles = Integer.parseInt(rawData[vehicles][column]);
        infrastructure.infrastructureTechnology = loadInfrastructureTechnology(rawData, column);
        infrastructure.infrastructureFunding = loadInfrastructureFunding(rawData, column);
        return infrastructure;
    }

    private static ImprovementsToLand loadImprovementsToLand(String[][] rawData, int column) {
        ImprovementsToLand land = new ImprovementsToLand();
        land.housingUnits = Integer.parseInt(rawData[housingUnits][column]);
        return land;
    }

    private static GovernmentFinances loadGovernmentFinances(String[][] rawData, int column) {
        GovernmentFinances governmentFinances = new GovernmentFinances();
        governmentFinances.totalReceipts = Long.parseLong(rawData[totalGovReceipts][column]);
        return governmentFinances;
    }

    private static Military loadMilitary(String[][] rawData, int column) {
        Military military = new Military();
        military.equipmentCapital = Long.parseLong(rawData[militaryEquipmentCapital][column]);
        military.soldiers = loadInt(rawData[Soldiers][column]);
        military.soldiersSalary = loadInt(rawData[SoldiersSalary][column]);
        military.soldiersSalary = loadInt(rawData[SoldiersSalary][column]);
        military.nationalConscriptionStartingAge = loadInt(rawData[NationalConscriptionStartingAgez][column]);
        military.nationalConscriptionEndingAge = loadInt(rawData[NationalConscriptionEndingAgez][column]);
        military.militaryEquipmentFunding = loadInt(rawData[militaryEquipmentFunding][column]);
        return military;
    }

    private static Assets loadAssets(String[][] rawData, int column) {
        Assets assets = new Assets();
        assets.pensionNetCapital = Long.parseLong(rawData[pensionNetCapital][column]);
        assets.nationalDebt = Long.parseLong(rawData[nationalDebt][column]);
        assets.assetsPrivate = Long.parseLong(rawData[assetsPrivate][column]);
        assets.assetsCorporate = Long.parseLong(rawData[assetsCorporate][column]);
        assets.stockMarketValue = Long.parseLong(rawData[stockMarketValue][column]);
        assets.m0 = Long.parseLong(rawData[m0][column]);
        assets.interestRates = loadInt(rawData[interestRates][column]);
        return assets;
    }

    private static MacroIndicators loadMacroIndicators(String[][] rawData, int column) {
        MacroIndicators indicators = new MacroIndicators();
        indicators.inflation = Integer.parseInt(rawData[inflation][column]);
        indicators.debtInterestRate = Integer.parseInt(rawData[debtInterestRate][column]);
        indicators.averageSalary = Long.parseLong(rawData[averageSalary][column]);
        indicators.cci = Integer.parseInt(rawData[cci][column]);
        indicators.gdp = Long.parseLong(rawData[gdp][column]);
        indicators.investments = Long.parseLong(rawData[investments][column]);
        indicators.netWages = Long.parseLong(rawData[netWages][column]);
        return indicators;
    }

    private static HealthCare loadHealthCare(String[][] rawData, int column) {
        HealthCare healthCare = new HealthCare();
        healthCare.healthCondition = Integer.parseInt(rawData[healthCondition][column]);
        healthCare.healthFundingOfHealthCareNeeds = loadInt(rawData[healthFundingOfHealthCareNeeds][column]);
        healthCare.healthMedicalStuffSalary = loadInt(rawData[healthMedicalStuffSalary][column]);
        return healthCare;
    }

    private static InfrastructureFunding loadInfrastructureFunding(String[][] rawData, int column) {
        InfrastructureFunding infrastructure = new InfrastructureFunding();
        infrastructure.roads = loadInt(rawData[infrastructureRoadwaysFunding][column]);
        infrastructure.highways = loadInt(rawData[infrastructureHighwaysFunding][column]);
        infrastructure.railways = loadInt(rawData[infrastructureRailwaysFunding][column]);
        infrastructure.airports = loadInt(rawData[infrastructureAirportsFunding][column]);
        infrastructure.docks = loadInt(rawData[infrastructureNavyFunding][column]);
        infrastructure.vehicles = loadInt(rawData[infrastructureVehiclesFunding][column]);
        return infrastructure;
    }

    private static Land loadLand(String[][] rawData, int column) {
        Land land = new Land();
        land.total = loadLong(rawData[LandTotalZ][column]);
        land.arable = loadLong(rawData[LandArableZ][column]);
        land.habitable = loadLong(rawData[LandHabitableZ][column]);
        land.infrastructure = loadInfrastructure(rawData, column);
        land.improvementsToLand = loadImprovementsToLand(rawData, column);
        return land;
    }

    private static Population loadPopulation(String[][] rawData, int column) {
        Population population = new Population();
        for (int x = popPyramidFirst; x <= popPyramidLast; x++) {
            population.pyramid[x - popPyramidFirst] = loadInt(rawData[x][column]);
        }
        return population;
    }

    private static Product[] loadProducts(String[][] rawData, int column, List<String> productNames) {
        Product[] products = new Product[productNames.size()];
        for (int x = 0; x < products.length; x++) {
            products[x] = new Product(productNames.get(x));
            loadProduct(x, column, rawData, products[x]);
        }
        return products;
    }

    private static void loadProduct(int productNum, int countryNum, String[][] rawData, Product product) {
        product.price = loadInt(rawData[pricesStart + productNum][countryNum]);
        product.employed = loadInt(rawData[employedStart + productNum][countryNum]);
        product.industrialProductivity = loadInt(rawData[indEffStart + productNum][countryNum]);
        product.actualTech = loadInt(rawData[actTechStart + productNum][countryNum]);
        product.assets = loadLong(rawData[assetsStart + productNum][countryNum]);
        product.endProductivity = loadInt(rawData[endProductivityStart + productNum][countryNum]);
    }
}
