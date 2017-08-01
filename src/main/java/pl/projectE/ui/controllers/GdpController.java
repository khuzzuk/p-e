package pl.projectE.ui.controllers;

import pl.projectE.model.Country;
import pl.projectE.ui.Cleaning;
import pl.projectE.ui.Formatter;
import pl.projectE.ui.NumberLabel;
import pl.projectE.ui.ValueFormatter;

public class GdpController extends Formatted {
    @Cleaning
    @Formatter(label = "gdp")
    public NumberLabel gdp;
    @Cleaning
    @Formatter(label = "gdp in $")
    public NumberLabel gdp$;
    @Cleaning
    @Formatter(label = "gdp/c", formatter = ValueFormatter.PRECISE)
    public NumberLabel gdpPerCapita;
    @Cleaning
    @Formatter(label = "gdp/c $", formatter = ValueFormatter.PRECISE)
    public NumberLabel gdpPerCapita$;
    @Cleaning
    @Formatter(label = "prop. to consume", formatter = ValueFormatter.PERCENT)
    public NumberLabel propensityToConsume;

    @Override
    public void showCountry(Country country) {
        gdp.setText(country.macroIndicators.gdp);
        gdp$.setText(country.macroIndicators.gdpIn$);
        gdpPerCapita.setText(country.macroIndicators.gdpPerCapita);
        gdpPerCapita$.setText(country.macroIndicators.gdpPerCapita$);
        propensityToConsume.setText(country.macroIndicators.propensityToConsume);
    }
}
