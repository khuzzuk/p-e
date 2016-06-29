package pl.projectE.inject;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.annotation.*;
import javax.inject.Inject;
import javax.inject.Named;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class InjectorTest {
    private InjectedClass injectedClass;

    @BeforeMethod(groups = "fast")
    public void setUp() throws Exception {
        injectedClass = new InjectedClass();
    }

    @Test(groups = "fast")
    public void checkInjectionForComponent() throws Exception {
        Assert.assertNotNull(injectedClass.injectedString);
    }

    @Test(groups = "fast")
    public void checkContainerSingletonPolicy() throws Exception {
        InjectedClass otherInjectedClass = new InjectedClass();
        assertEquals(injectedClass.injectedString, otherInjectedClass.injectedString);
    }

    @Test(groups = "fast")
    public void checkPostConstructExecution() throws Exception {
        assertTrue(injectedClass.postConstructExecuted);
    }

    @Test(expectedExceptions = InvocationWithWrongParameterException.class, groups = "fast")
    public void throwExceptionWithMethodWithParameters() throws Exception {
        new WrongInjectedClass();
    }

    @Test
    public void checkRecursiveInjection() throws Exception {
        OtherInjectedClass otherInjectedClass = new OtherInjectedClass();
        assertEquals(injectedClass, otherInjectedClass.injectedClass);
    }

    @Test
    public void checkInjectingComponentFromMethod() throws Exception {
        ClassWithComponentMethod creator = new ClassWithComponentMethod();
        InjectedClass injectedClass = creator.createObject();
        ClassWithNamedInject namedInject = new ClassWithNamedInject();
        assertEquals(injectedClass, namedInject.injectedClass);
    }

    @Component
    static class InjectedClass{
        @Inject
        private String injectedString;
        boolean postConstructExecuted = false;
        @PostConstruct
        void postConstructMethod(){
            postConstructExecuted = true;
        }
    }
    @Component
    private static class OtherInjectedClass{
        @Inject
        private InjectedClass injectedClass;
    }
    @Component
    private static class WrongInjectedClass{
        @PostConstruct
        private void wrongMethod(String s) {}
    }

    static class ClassWithComponentMethod {
        @Component
        @Named("injectedObject")
        private InjectedClass createObject(){
            return new InjectedClass();
        }
    }
    @Component
    static class ClassWithNamedInject {
        @Inject
        @Named("injectedObject")
        private InjectedClass injectedClass;
    }
}