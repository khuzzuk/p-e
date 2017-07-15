package pl.projectE.math;

import pl.projectE.model.government.TaxPolicy;

import static pl.projectE.math.MathUtils.average;

public class Calculations {
    public static int averageTaxRate(TaxPolicy tp) {
        return average(tp.pitLowMargin + tp.pitMediumMargin + tp.pitHighMargin) +
                tp.vat +
                tp.sales +
                average(tp.fromLandOwnership + tp.improvementsToLand + tp.movableProperty + tp.inheritance +
                tp.capitalGains + tp.financialTransactions + tp.tolls + tp.crimeFees);
    }

}
