package pl.projectE.ui.controllers;

import pl.projectE.model.Country;
import pl.projectE.model.economy.Employment;
import pl.projectE.ui.Cleaning;
import pl.projectE.ui.Formatter;
import pl.projectE.ui.NumberLabel;
import pl.projectE.ui.ValueFormatter;

public class EmploymentTabController extends Formatted {
    @Cleaning
    @Formatter(label = "un. benefits", isChangeable = true, maxValue = 1000, formatter = ValueFormatter.PERCENT)
    public NumberLabel unemploymentBenefits;
    @Formatter(label = "ben. duration", isChangeable = true, maxValue = 1000, formatter = ValueFormatter.PERCENT)
    public NumberLabel unemploymentBenefitsDuration;
    @Formatter(label = "ben. strength", isChangeable = true, maxValue = 1000, formatter = ValueFormatter.PERCENT)
    public NumberLabel unemploymentBenefitsStrength;
    @Formatter(label = "working age", isChangeable = true, maxValue = 100, formatter = ValueFormatter.SIMPLE)
    public NumberLabel workingAge;
    @Formatter(label = "min. salary", isChangeable = true, maxValue = 1000, formatter = ValueFormatter.PERCENT)
    public NumberLabel minimumSalary;
    @Formatter(label = "employed", formatter = ValueFormatter.BIG)
    public NumberLabel employed;
    @Formatter(label = "unemployed", formatter = ValueFormatter.BIG)
    public NumberLabel unemployed;
    @Formatter(label = "unempl. rate", formatter = ValueFormatter.PERCENT)
    public NumberLabel unemploymentRate;
    @Formatter(label = "empl. rate", formatter = ValueFormatter.PERCENT)
    public NumberLabel employmentRate;
    @Formatter(label = "spending", formatter = ValueFormatter.BIG)
    public NumberLabel spending;
    @Formatter(label = "admin. needs", formatter = ValueFormatter.SIMPLE)
    public NumberLabel administrationNeeds;

    @Override
    public void showCountry(Country country) {
        Employment employment = country.employment;
        unemploymentBenefits.setText(employment.unemploymentBenefits);
        unemploymentBenefitsDuration.setText(employment.unemploymentBenefitsDuration);
        unemploymentBenefitsStrength.setText(employment.unemploymentBenefitsStrength);
        workingAge.setText(employment.workingAge);
        minimumSalary.setText(employment.minimumSalary);
        employed.setText(employment.employed);
        unemployed.setText(employment.unemployed);
        unemploymentRate.setText(employment.unemploymentRate);
        employmentRate.setText(employment.employmentRate);
        administrationNeeds.setText(employment.administrationNeed);
        spending.setText(employment.spending);
    }
}
