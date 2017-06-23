package pl.projectE.loaders;

import lombok.experimental.UtilityClass;
import pl.projectE.model.Country;
import pl.projectE.model.economy.Employment;
import pl.projectE.model.government.*;
import pl.projectE.model.social.Education;
import pl.projectE.model.social.Pensions;

import static pl.projectE.loaders.FileVars.*;
import static pl.projectE.loaders.LoadersUtil.loadBoolean;
import static pl.projectE.loaders.LoadersUtil.loadInt;

@UtilityClass
class GovernmentActionsLoader {
    static void loadGovernmentActions(Country country, String[][] rawData, int column) {
        country.taxPolicy = loadTaxPolicy(rawData, column);
        country.administration = loadAdministration(rawData, column);
        country.employment = loadEmployment(rawData, column);
        country.pensions = loadPensions(rawData, column);
        country.education = loadEducation(rawData, column);
    }

    private static TaxPolicy loadTaxPolicy(String[][] rawData, int column) {
        TaxPolicy taxPolicy = new TaxPolicy();
        taxPolicy.pitLowMargin = Integer.parseInt(rawData[PITLowMargin][column]);
        taxPolicy.pitMediumMargin = Integer.parseInt(rawData[PITMediumMargin][column]);
        taxPolicy.pitHighMargin = Integer.parseInt(rawData[PITHighMargin][column]);
        taxPolicy.pitLowMarginThreshold = Integer.parseInt(rawData[PITLowMarginThreshold][column]);
        taxPolicy.pitMediumMarginThreshold = Integer.parseInt(rawData[PITMediumLimitThreshold][column]);
        taxPolicy.payroll = Integer.parseInt(rawData[Payroll][column]);
        taxPolicy.cit = Integer.parseInt(rawData[CIT][column]);
        taxPolicy.redundancy = Integer.parseInt(rawData[Redundancy][column]);
        taxPolicy.vat = Integer.parseInt(rawData[VAT][column]);
        taxPolicy.sales = Integer.parseInt(rawData[Sales][column]);
        taxPolicy.tariff = Integer.parseInt(rawData[Tariff][column]);
        taxPolicy.fromLandOwnership = Integer.parseInt(rawData[FromLandOwnership][column]);
        taxPolicy.improvementsToLand = Integer.parseInt(rawData[ImprovementsToLands][column]);
        taxPolicy.movableProperty = Integer.parseInt(rawData[MovableProperty][column]);
        taxPolicy.inheritance = Integer.parseInt(rawData[Inheritance][column]);
        taxPolicy.capitalGains = Integer.parseInt(rawData[CapitalGains][column]);
        taxPolicy.financialTransactions = Integer.parseInt(rawData[FinancialTransaction][column]);
        taxPolicy.tolls = Integer.parseInt(rawData[Tolls][column]);
        taxPolicy.crimeFees = Integer.parseInt(rawData[CrimeFees][column]);
        taxPolicy.governmentEmployee = rawData[GovernmentEmployee][column].equals("1");
        taxPolicy.governmentBenefactors = rawData[GovernmentBenefactors][column].equals("1");
        return taxPolicy;
    }

    private static Administration loadAdministration(String[][] rawData, int column) {
        Administration administration = new Administration();
        administration.officialsProjectedRate = loadInt(rawData[govOfficialsProjected][column]);
        administration.officialsSalary = loadInt(rawData[govOfficialsSalary][column]);
        administration.laws = loadLaws(rawData, column);
        administration.justice = loadJustice(rawData, column);
        return administration;
    }

    private static Laws loadLaws(String[][] rawData, int column) {
        Laws laws = new Laws();
        laws.freeAccessToEducation = loadBoolean(rawData[lawFreeAccessToEducation][column]);
        laws.freeDistrictCourts = loadBoolean(rawData[lawFreeDistrictCourts][column]);
        laws.freeInternet = loadBoolean(rawData[lawFreeInternet][column]);
        laws.freePress = loadBoolean(rawData[lawFreePress][column]);
        laws.freeSpeech = loadBoolean(rawData[lawFreeSpeech][column]);
        laws.freeSupremeCourt = loadBoolean(rawData[lawFreeSupremeCourt][column]);
        laws.heavyWeaponsForPolice = loadBoolean(rawData[lawHeavyWeaponsForPolice][column]);
        laws.oppressedDocumentVerification = loadBoolean(rawData[lawOppressedDocumentVerification][column]);
        laws.nationalLibrarySystem = loadBoolean(rawData[lawNationalLibrarySystem][column]);
        laws.religiousTolerance = loadBoolean(rawData[lawReligiousTolerance][column]);
        laws.tolerateIntolerant = loadBoolean(rawData[lawTolerateIntolerant][column]);
        laws.personalId = loadBoolean(rawData[lawPersonalId][column]);
        laws.taxInvestigations = loadBoolean(rawData[lawTaxInvestigations][column]);
        laws.rightToFairTrial = loadBoolean(rawData[lawRightToFairTrial][column]);
        int assimilation = loadInt(rawData[lawAssimilation][column]);
        switch (assimilation) {
            case 0:
                laws.assimilation = AssimilationPolicy.NO_ASSIMILATION;
            case 1:
                laws.assimilation = AssimilationPolicy.ASSIMILATION;
            case 2:
                laws.assimilation = AssimilationPolicy.NATURALISATION;
        }
        int migration = loadInt(rawData[lawMigrationPolicy][column]);
        switch (migration) {
            case 0:
                laws.immigrationPolicy = MigrationPolicy.OPEN;
                laws.emigrationPolicy = MigrationPolicy.OPEN;
            case 1:
                laws.immigrationPolicy = MigrationPolicy.LIMITED;
                laws.emigrationPolicy = MigrationPolicy.LIMITED;
            case 2:
                laws.immigrationPolicy = MigrationPolicy.LIMITED;
                laws.emigrationPolicy = MigrationPolicy.OPEN;
            case 3:
                laws.immigrationPolicy = MigrationPolicy.OPEN;
                laws.emigrationPolicy = MigrationPolicy.LIMITED;
            case 4:
                laws.immigrationPolicy = MigrationPolicy.LIMITED;
                laws.emigrationPolicy = MigrationPolicy.LIMITED;
        }
        return laws;
    }

    private static Justice loadJustice(String[][] rawData, int column) {
        Justice justice = new Justice();
        justice.courtJudgeSalary = loadInt(rawData[courtJudgeSalary][column]);
        justice.courtSupplyingJudge = loadInt(rawData[courtSupplyingJudge][column]);
        justice.policeEquipmentFunding = loadInt(rawData[policeEquipmentFunding][column]);
        justice.policeOfficersProjected = loadInt(rawData[policeOfficersProjected][column]);
        justice.policeOfficersSalary = loadInt(rawData[policeOfficersSalary][column]);
        return justice;
    }

    private static Employment loadEmployment(String[][] rawData, int column) {
        Employment employment = new Employment();
        employment.minimumSalary = loadInt(rawData[lawMinimumSalary][column]);
        employment.unemploymentBenefits = loadInt(rawData[socUnemploymentBenefits][column]);
        employment.unemploymentBenefitsDuration = loadInt(rawData[socUnemploymentBenefitsDuration][column]);
        employment.unemploymentBenefitsStrength = loadInt(rawData[UnemploymentBenefitsStrength][column]);
        employment.workingAge = loadInt(rawData[lawWorkingAge][column]);
        return employment;
    }

    private static Pensions loadPensions(String[][] rawData, int column) {
        Pensions pensions = new Pensions();
        pensions.governmentPensionFunding = loadInt(rawData[socGovernmentPensionFunding][column]);
        pensions.retirementAge = loadInt(rawData[lawRetirementAge][column]);
        return pensions;
    }

    private static Education loadEducation(String[][] rawData, int column) {
        Education education = new Education();
        education.numberOfEducationalDays = loadInt(rawData[eduNumberOfEducationalDaysz][column]);
        education.numberOfChildInGroups = loadInt(rawData[eduNumberOfChildInGroupsz][column]);
        education.teachersSalary = loadInt(rawData[eduTeachersSalary][column]);
        education.plannedStudents = loadInt(rawData[eduPlannedStudents][column]);
        education.fundingResearch = loadInt(rawData[eduFundingResearch][column]);
        education.naturalResourcesFunding = loadInt(rawData[eduNaturalResourcesFunding][column]);
        education.biomedicsFunding = loadInt(rawData[eduBiomedicsFunding][column]);
        education.engineeringFunding = loadInt(rawData[eduEngineeringFunding][column]);
        education.computersFunding = loadInt(rawData[eduComputersFunding][column]);
        education.mathematicsEconomyFunding = loadInt(rawData[eduMathematicsEconomyFunding][column]);
        education.physicsFunding = loadInt(rawData[eduPhysicsFunding][column]);
        education.socialSciencesFunding = loadInt(rawData[eduSocialSciencesFunding][column]);
        education.militaryFunding = loadInt(rawData[eduMilitaryFunding][column]);
        education.humanitiesFunding = loadInt(rawData[eduHumanitiesFunding][column]);
        education.artistryFunding = loadInt(rawData[eduArtistryFunding][column]);
        education.foreignLanguagesFunding = loadInt(rawData[eduForeignLanguagesFunding][column]);
        education.researchEquipmentFunding = loadInt(rawData[eduResearchEquipmentFunding][column]);
        return education;
    }
}
