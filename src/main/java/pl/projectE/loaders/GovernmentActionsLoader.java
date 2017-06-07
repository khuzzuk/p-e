package pl.projectE.loaders;

import lombok.experimental.UtilityClass;
import pl.projectE.model.Country;
import pl.projectE.model.government.TaxPolicy;

import static pl.projectE.loaders.FileVars.*;

@UtilityClass
class GovernmentActionsLoader {
    static void loadGovernmentActions(Country country, String[][] rawData, int column) {
        country.taxPolicy = loadTaxPolicy(rawData, column);
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
}
