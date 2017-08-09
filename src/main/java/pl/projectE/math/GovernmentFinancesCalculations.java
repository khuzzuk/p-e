package pl.projectE.math;

import pl.projectE.model.Country;

public class GovernmentFinancesCalculations {
    static long totalSpending(Country country) {
        return MathUtils.sum(country.employment.spending);
    }
}
