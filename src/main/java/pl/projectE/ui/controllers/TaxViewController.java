package pl.projectE.ui.controllers;

import pl.projectE.model.Country;
import pl.projectE.ui.Cleaning;
import pl.projectE.ui.Formatter;
import pl.projectE.ui.NumberLabel;
import pl.projectE.ui.ValueFormatter;

public class TaxViewController extends Formatted {
    @Formatter(label = "payroll", maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT, isChangeable = true)
    @Cleaning
    public NumberLabel payroll;
    @Formatter(label = "cit", maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT, isChangeable = true)
    @Cleaning
    public NumberLabel cit;
    @Formatter(label = "redundancy", maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT, isChangeable = true)
    @Cleaning
    public NumberLabel redundancy;
    @Formatter(label = "vat", maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT, isChangeable = true)
    @Cleaning
    public NumberLabel vat;
    @Formatter(label = "sales tax", maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT, isChangeable = true)
    @Cleaning
    public NumberLabel salesTax;
    @Formatter(label = "tariffs", maxValue = 950, change = 5, formatter = ValueFormatter.PERCENT, isChangeable = true)
    @Cleaning
    public NumberLabel tariffs;
    @Formatter(label = "land ownership", maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT, isChangeable = true)
    @Cleaning
    public NumberLabel landOwnership;
    @Formatter(label = "improvements to the land", maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT, isChangeable = true)
    @Cleaning
    public NumberLabel improvementsToLand;
    @Formatter(label = "movable property", maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT, isChangeable = true)
    @Cleaning
    public NumberLabel movableProperty;
    @Formatter(label = "inheritance", maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT, isChangeable = true)
    @Cleaning
    public NumberLabel inheritance;
    @Formatter(label = "capital gains", maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT, isChangeable = true)
    @Cleaning
    public NumberLabel capitalGains;
    @Formatter(label = "financial transactions", maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT, isChangeable = true)
    @Cleaning
    public NumberLabel financialTransactions;
    @Formatter(label = "tolls", maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT, isChangeable = true)
    @Cleaning
    public NumberLabel tolls;
    @Formatter(label = "crime fees", maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT, isChangeable = true)
    @Cleaning
    public NumberLabel crimeFees;
    @Formatter(label = "low", maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT, isChangeable = true)
    @Cleaning
    public NumberLabel pitLow;
    @Formatter(label = "med", maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT, isChangeable = true)
    @Cleaning
    public NumberLabel pitMed;
    @Formatter(label = "high", maxValue = 500, change = 5, formatter = ValueFormatter.PERCENT, isChangeable = true)
    @Cleaning
    public NumberLabel pitHigh;
    @Formatter(label = "low", maxValue = 10000, change = 5, formatter = ValueFormatter.PERCENT, isChangeable = true)
    @Cleaning
    public NumberLabel marginLow;
    @Formatter(label = "med", maxValue = 10000, change = 5, formatter = ValueFormatter.PERCENT, isChangeable = true)
    @Cleaning
    public NumberLabel marginMed;
    @Cleaning
    @Formatter(label = "receipts", formatter = ValueFormatter.BIG)
    public NumberLabel totalReceipts;
    @Cleaning
    @Formatter(label = "payroll", formatter = ValueFormatter.BIG)
    public NumberLabel payrollTaxation;
    @Cleaning
    @Formatter(label = "spending", formatter = ValueFormatter.BIG)
    public NumberLabel totalSpending;

    @Override
    public void showCountry(Country country) {
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

        totalReceipts.setText(country.governmentFinances.totalReceipts);
        payrollTaxation.setText(country.governmentFinances.payrollTaxation);

        totalSpending.setText(country.governmentFinances.totalSpending);
    }
}
