package pl.projectE.ui.controllers;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pl.projectE.model.Country;
import pl.projectE.ui.Cleaning;
import pl.projectE.ui.Formatter;
import pl.projectE.ui.NumberLabel;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public abstract class Formatted implements Initializable {
    Field[] fields;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fields = this.getClass().getDeclaredFields();
        formatFields();
    }

    private void formatFields() {
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
            value.formatter = formatter.formatter();
            Parent parent = value.getParent();
            if (parent instanceof HBox) {
                HBox hBox = (HBox) parent;
                hBox.setPadding(new Insets(5));
                if (formatter.isChangeable()) {
                    VBox vBox = new VBox();
                    Button increase = new Button("▲");
                    increase.setOnAction(e -> value.change(formatter.change()));
                    increase.getStyleClass().add("int-label-change");
                    Button decrease = new Button("▼");
                    decrease.setOnAction(e -> value.change(-formatter.change()));
                    decrease.getStyleClass().add("int-label-change");
                    vBox.getChildren().addAll(increase, decrease);
                    hBox.getChildren().add(0, vBox);
                }
                Label label = new Label(formatter.label());
                label.getStyleClass().add("int-label");
                hBox.getChildren().add(label);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    void clear() {
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

    public abstract void showCountry(Country country);
}
