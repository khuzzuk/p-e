package pl.projectE.math;

import pl.projectE.model.Country;
import pl.projectE.model.economy.MacroIndicators;

import static pl.projectE.math.MathUtils.divideUpscale;
import static pl.projectE.math.MathUtils.divideWithUpScaled;
import static pl.projectE.math.MathUtils.multiplyPercentsPositive;

class MacroIndicatorsCalculations {

    static long gdpIn$(Country country) {
        return divideWithUpScaled(country.macroIndicators.gdp, country.currencyData.cost);
    }

    static long gdpPerCapita(Country country) {
        return country.macroIndicators.gdp / country.population.totalPopulation;
    }

    static int gdpPerCapita$(Country country) {
        return (int) (country.macroIndicators.gdpIn$ / country.population.totalPopulation);
    }

    static int propensityToConsume(Country country) {
        MacroIndicators macroIndicators = country.macroIndicators;
        int wagesRatio = divideUpscale(macroIndicators.netWages, macroIndicators.gdp) / 2;
        return 400 + multiplyPercentsPositive(wagesRatio, macroIndicators.cci); //0,4 + (wr*(1 + cci))
    }
}
