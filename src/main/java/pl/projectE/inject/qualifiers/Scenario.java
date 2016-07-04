package pl.projectE.inject.qualifiers;

import javax.inject.Qualifier;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Qualifier
@Documented
public @interface Scenario {
}
