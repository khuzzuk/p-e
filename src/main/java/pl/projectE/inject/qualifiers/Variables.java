package pl.projectE.inject.qualifiers;

import javax.inject.Qualifier;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
@Qualifier
@Documented
public @interface Variables {
}
