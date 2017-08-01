package pl.projectE.math;

import pl.projectE.model.Country;
import pl.projectE.model.production.Product;

import static pl.projectE.math.MathUtils.*;

class EmploymentCalculations {
    static long employed(Country country) {
        long employed = 0;
        for (Product p : country.products) {
            employed += p.employed;
        }
        return employed;
    }

    static long unemployed(Country country) {
        return upscale(country.population.activeWorkForce) - country.employment.employed;
    }

    static int unemploymentRate(Country country) {
        long workForce = upscale(country.population.activeWorkForce);
        long unemployed = country.employment.unemployed;
        return divideUpscale(unemployed, workForce);
    }

    static int employmentRate(Country country) {
        long population = upscale(country.population.totalPopulation);
        long employed = country.employment.employed;
        return divideUpscale(employed, population);
    }

    static long spending(Country country) {
        int unemploymentRate = country.employment.unemploymentRate;
        int benefits = country.employment.unemploymentBenefits;
        int activeWorkForce = country.population.activeWorkForce;
        long averageSalary = country.macroIndicators.averageSalary;
        int benefitsDuration = country.employment.unemploymentBenefitsDuration;
        int a = multiplyPercents(unemploymentRate, benefits);
        long b = multiplyWithUpscaled(activeWorkForce, a);
        long c = multiplyWithUpscaled(averageSalary, b);
        return c * (benefitsDuration / 5);
    }
}
