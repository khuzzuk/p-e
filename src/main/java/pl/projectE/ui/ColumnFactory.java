package pl.projectE.ui;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import pl.projectE.model.Country;

import java.text.DecimalFormat;
import java.util.function.Function;

public interface ColumnFactory {
    DecimalFormat FORMATTER = new DecimalFormat("# ##0.00");
    default TableColumn<Country, String> getColumnWithString(String name,
                                                             Function<Country, String> setter) {
        TableColumn<Country, String> col = new TableColumn<>(name);
        col.setCellValueFactory(c -> new SimpleStringProperty(setter.apply(c.getValue())));
        return col;
    }

    default TableColumn<Country, String> getColumnWithLong(String name, double divider, String suffix,
                                                           Function<Country, Long> setter) {
        TableColumn<Country, String> col = new TableColumn<>(name);
        col.setCellValueFactory(c -> new SimpleStringProperty(FORMATTER
                .format(setter.apply((c.getValue())).doubleValue() / divider) + suffix));
        return col;
    }

    default TableColumn<Country, String> getColumnWithInt(String name, double divider, String suffix,
                                                          Function<Country, Integer> setter) {
        TableColumn<Country, String> col = new TableColumn<>(name);
        col.setCellValueFactory(c -> new SimpleStringProperty(FORMATTER
                .format(setter.apply((c.getValue())).doubleValue() / divider) + suffix));
        return col;
    }

    default TableColumn<Country, String> getColumnWithBoolean(String name,
                                                              Function<Country, Boolean> setter) {
        TableColumn<Country, String> col = new TableColumn<>(name);
        col.setCellValueFactory(c -> new SimpleStringProperty(setter.apply(c.getValue()) ? "true" : "false"));
        return col;
    }
}
