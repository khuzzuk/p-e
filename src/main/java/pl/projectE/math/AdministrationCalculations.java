package pl.projectE.math;

import pl.projectE.model.Country;

import static pl.projectE.math.MathUtils.multiplyDownscaledWithUpscaled;
import static pl.projectE.math.MathUtils.multiplyPercents;

public class AdministrationCalculations {
    public static int ADMIN_PRICE_TABLE_NUMBER;
    static long officialsSalaryTotal(Country country) {
        return multiplyPercents(country.macroIndicators.averageSalary, country.administration.officialsSalary);
    }

    static int officialsTotal(Country country) {
        return multiplyDownscaledWithUpscaled(
                country.population.totalPopulation,
                country.administration.officialsProjectedRate);
    }

    static long spending(Country country) {
        return multiplyDownscaledWithUpscaled(
                country.administration.officialsTotal,
                country.administration.officialsSalaryTotal);
    }

    static int administrationCost(Country country) {
        return country.products[ADMIN_PRICE_TABLE_NUMBER].price;
    }
}
