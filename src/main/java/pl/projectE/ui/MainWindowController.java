package pl.projectE.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.NonNull;
import pl.projectE.model.Country;

import java.lang.reflect.Field;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.SortedMap;

import static pl.projectE.App.bus;

public class MainWindowController implements Initializable {
    @FXML
    @Formatter(maxValue = 50, divider = 10, suffix = "%", change = 5)
    @Cleaning
    private NumberLabel payroll;
    @FXML
    @Formatter(maxValue = 50, divider = 10, suffix = "%", change = 5)
    @Cleaning
    private NumberLabel cit;
    @FXML
    @Formatter(maxValue = 50, divider = 10, suffix = "%", change = 5)
    @Cleaning
    private NumberLabel redundancy;
    @FXML
    @Formatter(maxValue = 50, divider = 10, suffix = "%", change = 5)
    @Cleaning
    private NumberLabel vat;
    @FXML
    @Formatter(maxValue = 50, divider = 10, suffix = "%", change = 5)
    @Cleaning
    private NumberLabel salesTax;
    @FXML
    @Formatter(maxValue = 95, divider = 10, suffix = "%", change = 5)
    @Cleaning
    private NumberLabel tariffs;
    @FXML
    @Formatter(maxValue = 50, divider = 10, suffix = "%", change = 5)
    @Cleaning
    private NumberLabel landOwnership;
    @FXML
    @Formatter(maxValue = 50, divider = 10, suffix = "%", change = 5)
    @Cleaning
    private NumberLabel improvementsToLand;
    @FXML
    @Formatter(maxValue = 50, divider = 10, suffix = "%", change = 5)
    @Cleaning
    private NumberLabel movableProperty;
    @FXML
    @Formatter(maxValue = 50, divider = 10, suffix = "%", change = 5)
    @Cleaning
    private NumberLabel inheritance;
    @FXML
    @Formatter(maxValue = 50, divider = 10, suffix = "%", change = 5)
    @Cleaning
    private NumberLabel capitalGains;
    @FXML
    @Formatter(maxValue = 50, divider = 10, suffix = "%", change = 5)
    @Cleaning
    private NumberLabel financialTransactions;
    @FXML
    @Formatter(maxValue = 50, divider = 10, suffix = "%", change = 5)
    @Cleaning
    private NumberLabel tolls;
    @FXML
    @Formatter(maxValue = 50, divider = 10, suffix = "%", change = 5)
    @Cleaning
    private NumberLabel crimeFees;
    @FXML
    @Formatter(maxValue = 50, divider = 10, suffix = "%", change = 5)
    @Cleaning
    private NumberLabel pitLow;
    @FXML
    @Formatter(maxValue = 50, divider = 10, suffix = "%", change = 5)
    @Cleaning
    private NumberLabel pitMed;
    @FXML
    @Formatter(maxValue = 50, divider = 10, suffix = "%", change = 5)
    @Cleaning
    private NumberLabel pitHigh;
    @FXML
    @Formatter(maxValue = 1000, divider = 10, suffix = "%", change = 5)
    @Cleaning
    private NumberLabel marginLow;
    @FXML
    @Formatter(maxValue = 1000, divider = 10, suffix = "%", change = 5)
    @Cleaning
    private NumberLabel marginMed;

    @FXML
    @Cleaning(type = Cleaning.Type.COMBO_BOX)
    private ComboBox<String> countriesList;
    private Field[] fields;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fields = this.getClass().getDeclaredFields();

        bus.setGuiReaction("scenario.show", this::loadScenario);
        bus.setGuiReaction("scenario.show.country", this::showCountry);

        initFormatter();
    }

    private void initFormatter() {
        Arrays.stream(fields)
                .filter(f -> f.isAnnotationPresent(Formatter.class))
                .filter(f -> f.getType().equals(NumberLabel.class))
                .forEach(this::setFormatting);
    }

    private void setFormatting(Field field) {
        Formatter formatter = field.getAnnotation(Formatter.class);
        try {
            NumberLabel value = (NumberLabel) field.get(this);
            value.minValue = formatter.minValue();
            value.maxValue = formatter.maxValue();
            value.divider = formatter.divider();
            value.suffix = formatter.suffix();
            value.format = new DecimalFormat(formatter.decimalFormat());
            Parent parent = value.getParent();
            if (parent instanceof HBox) {
                VBox vBox = new VBox();
                Button increase = new Button("▲");
                increase.setOnAction(e -> value.change(formatter.change()));
                increase.getStyleClass().add("int-label-change");
                Button decrease = new Button("▼");
                decrease.setOnAction(e -> value.change(-formatter.change()));
                decrease.getStyleClass().add("int-label-change");
                vBox.getChildren().addAll(increase, decrease);
                ((HBox) parent).getChildren().add(vBox);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void get2010Scenario() {
        clear();
        bus.sendCommunicate("scenario.loader.load.2010", "scenario.show");
    }

    private void loadScenario(@NonNull SortedMap<String, Country> countries) {
        countriesList.getItems().addAll(countries.keySet());
    }

    private void clear() {
        Arrays.stream(fields)
                .filter(f -> f.isAnnotationPresent(Cleaning.class))
                .forEach(this::clearField);
    }

    private void clearField(Field field) {
        try {
            field.getAnnotation(Cleaning.class).type().cleaner.accept(field.get(this));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
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
    }
}
