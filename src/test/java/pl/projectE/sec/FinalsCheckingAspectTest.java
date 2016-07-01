package pl.projectE.sec;

import org.assertj.core.util.VisibleForTesting;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.projectE.inject.Component;
import pl.projectE.inject.FinalAfterInject;

import javax.inject.Inject;

public class FinalsCheckingAspectTest {
    @Test(groups = "fast", expectedExceptions = FinalFieldSettingException.class)
    public void throwExceptionOnChangingFinalField() throws Exception {
        ClassWithFinals classWithFinals = new ClassWithFinals(new Object());
        classWithFinals.o = new Object();
    }

    @Test(groups = "fast")
    public void checkProperInitializationOfFinals() throws Exception {
        ClassWithFinals classWithFinals = new ClassWithFinals(new Object());
        Assert.assertNotNull(classWithFinals.o);
    }

    @Test(groups = "fast")
    public void checkIfInjectOfFinalsIsPossible() throws Exception {
        ClassWithFinalInjectedField finalInjectedField = new ClassWithFinalInjectedField();
        Assert.assertNotNull(finalInjectedField.o);
    }

    @Test(groups = "fast", expectedExceptions = FinalFieldSettingException.class)
    public void throwExceptionOnChangingInjectedFinal() throws Exception {
        ClassWithFinalInjectedField finalInjectedField = new ClassWithFinalInjectedField();
        finalInjectedField.o = new Object();
    }

    @VisibleForTesting
    @SuppressWarnings("WeakerAccess")
    static class ClassWithFinals {
        @Final
        Object o;

        public ClassWithFinals(Object o) {
            this.o = o;
        }
    }

    @Component
    static class ClassWithFinalInjectedField {
        @FinalAfterInject
        @Inject
        Object o;
    }
}