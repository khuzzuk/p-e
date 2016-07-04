package pl.projectE.inject;

import org.assertj.core.util.VisibleForTesting;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.projectE.sec.FinalAfterInject;

import javax.annotation.*;
import javax.inject.Inject;
import javax.inject.Named;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

public class InjectorElementTest {
    private InjectedClass injectedClass;

    @BeforeMethod(groups = "fast")
    public void setUp() throws Exception {
        injectedClass = new InjectedClass();
    }

    @Test(groups = "fast")
    public void checkInjectionForComponent() {
        Assert.assertNotNull(injectedClass.injectedString);
    }

    @Test(groups = "fast")
    public void checkContainerSingletonPolicy() {
        InjectedClass otherInjectedClass = new InjectedClass();
        assertEquals(injectedClass.injectedString, otherInjectedClass.injectedString);
    }

    @Test(groups = "fast")
    public void checkPostConstructExecution() {
        assertTrue(injectedClass.postConstructExecuted);
    }

    @Test(expectedExceptions = InvocationWithWrongParameterException.class, groups = "fast")
    public void throwExceptionWithMethodWithParameters() {
        new WrongInjectedClass();
    }

    @Test(groups = "fast")
    public void checkRecursiveInjection() {
        RecursiveInjectedClass recursiveInjectedClass = new RecursiveInjectedClass();
        assertEquals(recursiveInjectedClass.injectedClass.injectedClass, injectedClass);
    }

    @Test(groups = "fast")
    public void checkInjectingComponentFromMethod() {
        ClassWithComponentMethod creator = new ClassWithComponentMethod();
        InjectedClass injectedClass = creator.createObject();
        ClassWithNamedInject namedInject = new ClassWithNamedInject();
        assertEquals(injectedClass, namedInject.injectedClass);
    }

    @Test(groups = "fast")
    public void checkAlwaysNewPolicy() {
        AlwaysNewClass alwaysNewClass = new AlwaysNewClass();
        assertNotEquals(alwaysNewClass.injectedClass, injectedClass);
    }

    @Component
    @VisibleForTesting
    @SuppressWarnings("WeakerAccess")
    static class InjectedClass {
        @Inject
        @FinalAfterInject
        private String injectedString;
        boolean postConstructExecuted = false;

        @PostConstruct
        void postConstructMethod() {
            postConstructExecuted = true;
        }
    }

    @SuppressWarnings({"unused", "WeakerAccess"})
    @Component
    @VisibleForTesting
    static class OtherInjectedClass {
        @Inject
        private InjectedClass injectedClass;
    }

    @Component
    private static class RecursiveInjectedClass {
        @Inject
        private OtherInjectedClass injectedClass;
    }

    @Component
    private static class WrongInjectedClass {
        @SuppressWarnings("EmptyMethod")
        @PostConstruct
        private void wrongMethod(String s) {
        }
    }

    @Component
    private static class AlwaysNewClass {
        @Inject
        @AlwaysNew
        private InjectedClass injectedClass;
    }

    @VisibleForTesting
    @SuppressWarnings("WeakerAccess")
    static class ClassWithComponentMethod {
        @Component
        @Named("injectedObject")
        private InjectedClass createObject() {
            return new InjectedClass();
        }
    }

    @Component
    @VisibleForTesting
    @SuppressWarnings("WeakerAccess")
    static class ClassWithNamedInject {
        @Inject
        @Named("injectedObject")
        private InjectedClass injectedClass;
    }
}