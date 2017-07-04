package pl.projectE.ui;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Formatter {
    int minValue() default 0;

    int maxValue() default Integer.MAX_VALUE;

    int change() default 1;

    ValueFormatter formatter() default ValueFormatter.BIG;

    boolean isChangeable() default false;
}
