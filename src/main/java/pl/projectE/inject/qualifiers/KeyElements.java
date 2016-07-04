package pl.projectE.inject.qualifiers;

import javax.inject.Qualifier;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Qualifier
@Documented
public @interface KeyElements {
}
