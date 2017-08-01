package pl.projectE.ui.controllers;

import pl.projectE.model.Country;
import pl.projectE.ui.Cleaning;
import pl.projectE.ui.Formatter;
import pl.projectE.ui.NumberLabel;
import pl.projectE.ui.ValueFormatter;

public class AdministrationController extends Formatted {

    @Cleaning
    @Formatter(label = "officials projected", formatter = ValueFormatter.PERCENT)
    public NumberLabel officialsProjectedRate;
    @Cleaning
    @Formatter(label = "officials total", formatter = ValueFormatter.SIMPLE)
    public NumberLabel officialsTotal;
    @Cleaning
    @Formatter(label = "officials salary rate", formatter = ValueFormatter.PERCENT)
    public NumberLabel officialsSalaryRate;
    @Cleaning
    @Formatter(label = "officials salary", formatter = ValueFormatter.PRECISE)
    public NumberLabel officialsSalary;
    @Cleaning
    @Formatter(label = "spending", formatter = ValueFormatter.BIG)
    public NumberLabel spending;
    @Cleaning
    @Formatter(label = "adm. cost", formatter = ValueFormatter.PRECISE)
    public NumberLabel administrationCost;

    @Override
    public void showCountry(Country country) {
        officialsProjectedRate.setText(country.administration.officialsProjectedRate);
        officialsTotal.setText(country.administration.officialsTotal);
        officialsSalaryRate.setText(country.administration.officialsSalary);
        officialsSalary.setText(country.administration.officialsSalaryTotal);
        spending.setText(country.administration.spending);
        administrationCost.setText(country.administration.administrationCost);
    }
}
