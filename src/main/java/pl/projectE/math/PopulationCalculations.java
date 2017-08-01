package pl.projectE.math;

import pl.projectE.model.Country;
import pl.projectE.model.demography.Population;

import static pl.projectE.math.MathUtils.*;

class PopulationCalculations {

    static int totalPopulation(Population population) {
        return sum(population.pyramid);
    }

    static int popLaborForce(Country country) {
        return sum(country.population.pyramid, country.employment.workingAge, country.pensions.retirementAge);
    }

    static int popRetired(Country country) {
        return sum(country.population.pyramid, country.pensions.retirementAge, country.population.pyramid.length);
    }

    static int popUnderWorkingAge(Country country) {
        return sum(country.population.pyramid, 0, country.employment.workingAge);
    }

    static int nonLaborForceRatio(Country country) {
        int underWorkingAge = country.population.underWorkingAge;
        int laborForce = country.population.laborForce;
        int unemploymentBenefitsStrength = country.employment.unemploymentBenefitsStrength;
        int childrenRatio = divideUpscale(underWorkingAge, laborForce);
        return multiplyPercentsPositive(childrenRatio, unemploymentBenefitsStrength / 2);
    }

    static int activeLaborForce(Country country) {
        return getByPercentReversed(country.population.laborForce, country.population.nonLaborForceRatio);
    }

    static int popPerSqKm(Country country) {
        return calculatePercentBig(country.population.totalPopulation, country.land.total);
    }
}
