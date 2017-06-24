package pl.projectE.loaders;

import lombok.experimental.UtilityClass;
import pl.projectE.model.Country;
import pl.projectE.model.economy.Assets;
import pl.projectE.model.economy.MacroIndicators;
import pl.projectE.model.government.GovernmentFinances;
import pl.projectE.model.government.Military;
import pl.projectE.model.land.ImprovementsToLand;
import pl.projectE.model.land.Infrastructure;
import pl.projectE.model.land.InfrastructureFunding;
import pl.projectE.model.land.InfrastructureTechnology;
import pl.projectE.model.social.CivilSecurity;
import pl.projectE.model.social.HealthCare;
import pl.projectE.model.social.SocialIndicators;
import pl.projectE.model.social.Technology;

import static pl.projectE.loaders.FileVars.*;
import static pl.projectE.loaders.LoadersUtil.loadInt;

@UtilityClass
class DeterminantsLoader {
    static void setCountryDeterminants(String[][] rawData, Country country, int x) {
        country.assets = loadAssets(rawData, x);
        country.macroIndicators = loadMacroIndicators(rawData, x);
        country.military = loadMilitary(rawData, x);
        country.improvementsToLand = loadImprovementsToLand(rawData, x);
        country.infrastructure = laodInfrastructure(rawData, x);
        country.infrastructure.infrastructureTechnology = loadInfrastructureTechnology(rawData, x);
        country.infrastructure.infrastructureFunding = loadInfrastructureFunding(rawData, x);
        country.socialIndicators = loadSocialIndicators(rawData, x);
        country.civilSecurity = loadCivilSecurity(rawData, x);
        country.healthCare = loadHealthCare(rawData, x);
        country.technology = loadTechnology(rawData, x);
        country.governmentFinances = loadGovernmentFinances(rawData, x);
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

    private static Infrastructure laodInfrastructure(String[][] rawData, int column) {
        Infrastructure infrastructure = new Infrastructure();
        infrastructure.roads = Integer.parseInt(rawData[roads][column]);
        infrastructure.highways = Integer.parseInt(rawData[highways][column]);
        infrastructure.railways = Integer.parseInt(rawData[railways][column]);
        infrastructure.airports = Integer.parseInt(rawData[airports][column]);
        infrastructure.docks = Integer.parseInt(rawData[docks][column]);
        infrastructure.vehicles = Integer.parseInt(rawData[vehicles][column]);
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
}
