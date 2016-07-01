package pl.projectE.inject;

import com.sun.istack.internal.Nullable;
import org.apache.commons.collections4.map.HashedMap;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

@SuppressWarnings("WeakerAccess")
@Aspect
public class Injector {
    private final Map<ContainerKey, Object> container = new HashedMap<>();
    private final PostConstructCaller caller = new PostConstructCaller();
    private final InstantiationHandler instantiationHandler = new InstantiationHandler();

    @After("execution(*.new(..)) && @within(pl.projectE.inject.Component) && target(o)")
    public void inject(Object o) {
        injectFieldsToClassHierarchy(o);
        caller.callPostConstructMethods(o);
        ContainerKey key = ContainerKey.getKey(o.getClass());
        container.put(key, o);
    }

    @AfterReturning(value = "execution(* *.*(..)) && @annotation(pl.projectE.inject.Component)", returning = "o", argNames = "o,joinPoint")
    public void putToContainer(Object o, JoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        container.put(ContainerKey.getKey(method), o);
    }

    private void injectFieldsToClassHierarchy(Object o) {
        Class<?> c = o.getClass();
        while (c != Object.class) {
            injectFieldsToClass(c, o);
            c = c.getSuperclass();
        }
    }

    private void injectFieldsToClass(Class<?> c, Object o) {
        for (Field field : c.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class))
                injectField(field, o);
        }
    }

    private void injectField(Field field, Object o) {
        ContainerKey key = ContainerKey.getKey(field);
        if (!field.isAnnotationPresent(AlwaysNew.class) && container.containsKey(key)) {
            setValueInField(field, o, container.get(key));
        } else {
            setValueInField(field, o, instantiationHandler.instantiateNewClass(field));
        }
    }

    private void setValueInField(Field field, Object component, @Nullable Object toInject) {
        field.setAccessible(true);
        try {
            field.set(component, toInject);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
