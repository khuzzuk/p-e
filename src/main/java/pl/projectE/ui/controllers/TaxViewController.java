package pl.projectE.ui.controllers;

import pl.projectE.model.Country;
import pl.projectE.ui.Cleaning;
import pl.projectE.ui.Formatter;
import pl.projectE.ui.NumberLabel;
import pl.projectE.ui.ValueFormatter;

import java.net.URL;
import java.util.ResourceBundle;

public class TaxViewController extends Formatted {
    @Formatter(maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT)
    @Cleaning
    public NumberLabel payroll;
    @Formatter(maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT)
    @Cleaning
    public NumberLabel cit;
    @Formatter(maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT)
    @Cleaning
    public NumberLabel redundancy;
    @Formatter(maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT)
    @Cleaning
    public NumberLabel vat;
    @Formatter(maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT)
    @Cleaning
    public NumberLabel salesTax;
    @Formatter(maxValue = 950, change = 5, formatter = ValueFormatter.PERCENT)
    @Cleaning
    public NumberLabel tariffs;
    @Formatter(maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT)
    @Cleaning
    public NumberLabel landOwnership;
    @Formatter(maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT)
    @Cleaning
    public NumberLabel improvementsToLand;
    @Formatter(maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT)
    @Cleaning
    public NumberLabel movableProperty;
    @Formatter(maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT)
    @Cleaning
    public NumberLabel inheritance;
    @Formatter(maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT)
    @Cleaning
    public NumberLabel capitalGains;
    @Formatter(maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT)
    @Cleaning
    public NumberLabel financialTransactions;
    @Formatter(maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT)
    @Cleaning
    public NumberLabel tolls;
    @Formatter(maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT)
    @Cleaning
    public NumberLabel crimeFees;
    @Formatter(maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT)
    @Cleaning
    public NumberLabel pitLow;
    @Formatter(maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT)
    @Cleaning
    public NumberLabel pitMed;
    @Formatter(maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT)
    @Cleaning
    public NumberLabel pitHigh;
    @Formatter(maxValue = 10000, change = 5, formatter = ValueFormatter.PERCENT)
    @Cleaning
    public NumberLabel marginLow;
    @Formatter(maxValue = 10000, change = 5, formatter = ValueFormatter.PERCENT)
    @Cleaning
    public NumberLabel marginMed;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
    }

    void showCountry(Country country) {
        pitLow.setText(country.taxPolicy.pitLowMargin);
        pitMed.setText(country.taxPolicy.pitMediumMargin);
        pitHigh.setText(country.taxPolicy.pitHighMargin);
        marginLow.setText(country.taxPolicy.pitLowMarginThreshold);
        marginMed.setText(country.taxPolicy.pitMediumMarginThreshold);
        crimeFees.setText(country.taxPolicy.crimeFees);
        tolls.setText(country.taxPolicy.tolls);
        financialTransactions.setText(country.taxPolicy.financialTransactions);
        capitalGains.setText(country.taxPolicy.capitalGains);
        inheritance.setText(country.taxPolicy.inheritance);
        movableProperty.setText(country.taxPolicy.movableProperty);
        improvementsToLand.setText(country.taxPolicy.improvementsToLand);
        landOwnership.setText(country.taxPolicy.fromLandOwnership);
        tariffs.setText(country.taxPolicy.tariff);
        salesTax.setText(country.taxPolicy.sales);
        vat.setText(country.taxPolicy.vat);
        redundancy.setText(country.taxPolicy.redundancy);
        cit.setText(country.taxPolicy.cit);
        payroll.setText(country.taxPolicy.payroll);
    }
}
