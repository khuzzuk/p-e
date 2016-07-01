package pl.projectE.inject;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Documented
public @interface AlwaysNew {
}
