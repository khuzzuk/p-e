package pl.projectE.math;

import pl.projectE.model.Country;
import pl.projectE.model.demography.Population;

import static pl.projectE.math.MathUtils.divideUpscale;
import static pl.projectE.math.MathUtils.sum;

public class PopulationCalculations {
    public static void refreshPopulation(Country country) {
        Population population = country.population;
        population.totalPopulation = totalPopulation(population);
        population.laborForce = popLaborForce(country);
        population.retired = popRetired(country);
        population.underWorkingAge = popUnderWorkingAge(country);
        population.laborForceRatio = laborForceRatio(country);
    }

    public static int totalPopulation(Population population) {
        return sum(population.pyramid);
    }

    public static int popLaborForce(Country country) {
        return sum(country.population.pyramid, country.employment.workingAge, country.pensions.retirementAge);
    }

    public static int popRetired(Country country) {
        return sum(country.population.pyramid, country.pensions.retirementAge, country.population.pyramid.length);
    }

    public static int popUnderWorkingAge(Country country) {
        return sum(country.population.pyramid, 0, country.employment.workingAge);
    }

    public static int laborForceRatio(Country country) {
        int underWorkingAge = country.population.underWorkingAge;
        int laborForce = country.population.laborForce / 1000;
        int unemploymentBenefitsStrength = country.employment.unemploymentBenefitsStrength;
        return divideUpscale(underWorkingAge, laborForce) * (1 + unemploymentBenefitsStrength);
    }
}
