package pl.projectE.ui;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;

import java.text.DecimalFormat;
import java.util.function.Function;

public interface ColumnFactory<T> {
    DecimalFormat FORMATTER = new DecimalFormat("# ##0.00");
    default TableColumn<T, String> getColumnWithString(String name,
                                                             Function<T, String> setter) {
        TableColumn<T, String> col = new TableColumn<>(name);
        col.setCellValueFactory(c -> new SimpleStringProperty(setter.apply(c.getValue())));
        return col;
    }

    default TableColumn<T, String> getColumn(String name, ValueFormatter valueFormatter,
                                                           Function<T, Number> setter) {
        TableColumn<T, String> col = new TableColumn<>(name);
        col.setCellValueFactory(c ->
                new SimpleStringProperty(valueFormatter.forNumber(setter.apply(c.getValue()).doubleValue())));
        return col;
    }

    default TableColumn<T, String> getColumnWithBoolean(String name,
                                                              Function<T, Boolean> setter) {
        TableColumn<T, String> col = new TableColumn<>(name);
        col.setCellValueFactory(c -> new SimpleStringProperty(setter.apply(c.getValue()) ? "true" : "false"));
        return col;
    }

    default TableColumn<T, String> getColumnWithEnum(String name,
                                                              Function<T, Enum<?>> setter) {
        TableColumn<T, String> col = new TableColumn<>(name);
        col.setCellValueFactory(c -> new SimpleStringProperty(setter.apply(c.getValue()).name()));
        return col;
    }
}
