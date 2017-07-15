package pl.projectE.ui.controllers;

import pl.projectE.model.Country;
import pl.projectE.ui.Cleaning;
import pl.projectE.ui.Formatter;
import pl.projectE.ui.NumberLabel;
import pl.projectE.ui.ValueFormatter;

public class PopulationViewController extends Formatted {
    @Formatter(label = "population", formatter = ValueFormatter.BIG_DOWNGRADED)
    @Cleaning
    public NumberLabel population;
    @Formatter(label = "labor force", formatter = ValueFormatter.BIG_DOWNGRADED)
    @Cleaning
    public NumberLabel laborForce;
    @Formatter(label = "retired", formatter = ValueFormatter.BIG_DOWNGRADED)
    @Cleaning
    public NumberLabel retired;
    @Formatter(label = "under working age", formatter = ValueFormatter.BIG_DOWNGRADED)
    @Cleaning
    public NumberLabel children;
    @Formatter(label = "labor force ratio", formatter = ValueFormatter.PERCENT)
    @Cleaning
    public NumberLabel laborForceRatio;

    @Override
    public void showCountry(Country country) {
        population.setText(country.population.totalPopulation);
        laborForce.setText(country.population.laborForce);
        retired.setText(country.population.retired);
        children.setText(country.population.underWorkingAge);
        laborForceRatio.setText(country.population.laborForceRatio);
    }
}
