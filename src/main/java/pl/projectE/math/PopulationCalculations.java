package pl.projectE.math;

import pl.projectE.model.Country;
import pl.projectE.model.demography.Population;

import static pl.projectE.math.MathUtils.*;

class PopulationCalculations {
    static void refreshPopulation(Country country) {
        Population population = country.population;
        population.totalPopulation = totalPopulation(population);
        population.laborForce = popLaborForce(country);
        population.retired = popRetired(country);
        population.underWorkingAge = popUnderWorkingAge(country);
        population.nonLaborForceRatio = nonLaborForceRatio(country);
        population.activeWorkForce = activeLaborForce(country);
    }

    private static int totalPopulation(Population population) {
        return sum(population.pyramid);
    }

    private static int popLaborForce(Country country) {
        return sum(country.population.pyramid, country.employment.workingAge, country.pensions.retirementAge);
    }

    private static int popRetired(Country country) {
        return sum(country.population.pyramid, country.pensions.retirementAge, country.population.pyramid.length);
    }

    private static int popUnderWorkingAge(Country country) {
        return sum(country.population.pyramid, 0, country.employment.workingAge);
    }

    private static int nonLaborForceRatio(Country country) {
        int underWorkingAge = country.population.underWorkingAge;
        int laborForce = country.population.laborForce;
        int unemploymentBenefitsStrength = country.employment.unemploymentBenefitsStrength;
        int childrenRatio = divideUpscale(underWorkingAge, laborForce);
        return multiplyPercentsPositive(childrenRatio, unemploymentBenefitsStrength / 2);
    }

    private static int activeLaborForce(Country country) {
        return getByPercentReversed(country.population.laborForce, country.population.nonLaborForceRatio);
    }
}
