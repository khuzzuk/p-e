package pl.projectE.inject;

import javax.inject.Qualifier;
import java.lang.annotation.*;

@Qualifier
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
public @interface CountriesNames {
}
