package pl.projectE.ui.controllers;

import pl.projectE.math.Calculations;
import pl.projectE.model.Country;
import pl.projectE.ui.Cleaning;
import pl.projectE.ui.Formatter;
import pl.projectE.ui.NumberLabel;

public class PopulationViewController extends Formatted {
    @Formatter
    @Cleaning
    public NumberLabel population;

    @Override
    public void showCountry(Country country) {
        population.setText(Calculations.totalPopulation(country.population));
    }
}
