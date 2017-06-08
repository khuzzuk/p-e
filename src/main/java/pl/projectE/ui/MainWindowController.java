package pl.projectE.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.NonNull;
import pl.projectE.model.Country;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;

import static pl.projectE.App.bus;

public class MainWindowController extends Formatted {
    public TaxTableView taxes;
    public RevenuesTableView revenues;
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

    @Cleaning(type = Cleaning.Type.COMBO_BOX)
    public ComboBox<String> countriesList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        bus.setGuiReaction("scenario.show", this::loadScenario);
        bus.setGuiReaction("scenario.show.country", this::showCountry);
    }

     public void get2010Scenario() {
        clear();
        bus.sendCommunicate("scenario.loader.load.2010", "scenario.show");
    }

    private void loadScenario(@NonNull SortedMap<String, Country> countries) {
        countriesList.getItems().addAll(countries.keySet());
        Collection<Country> countriesData = countries.values();
        taxes.getItems().addAll(countriesData);
        revenues.getItems().addAll(countriesData);
    }

    @FXML
    private void loadCountry() {
        Optional.ofNullable(countriesList.getSelectionModel().getSelectedItem())
                .ifPresent(selectedItem -> bus.send("scenario.load.country",
                        "scenario.show.country",
                        selectedItem));
    }

    private void showCountry(Country country) {
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
