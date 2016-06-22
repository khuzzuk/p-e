package pl.projectE.sec;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface SynchronizedAccess {
}
