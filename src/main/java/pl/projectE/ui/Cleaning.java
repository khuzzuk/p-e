package pl.projectE.ui;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import lombok.RequiredArgsConstructor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.Consumer;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cleaning {
    Type type() default Type.NUMERIC;

    @RequiredArgsConstructor
    enum Type {
        NUMERIC(c -> ((NumberLabel)c).setText(0)),
        TEXT(c -> ((Label)c).setText("")),
        COMBO_BOX(c -> ((ComboBox<?>)c).getItems().clear());

        final Consumer cleaner;
    }
}
