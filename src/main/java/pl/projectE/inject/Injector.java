package pl.projectE.inject;

import com.sun.istack.internal.Nullable;
import org.apache.commons.collections4.map.HashedMap;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import pl.projectE.inject.qualifiers.Implementation;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

@Aspect
public class Injector {
    private Map<ContainerKey, Object> container = new HashedMap<>();
    private PostConstructCaller caller = new PostConstructCaller();

    @After("execution(*.new(..)) && @within(pl.projectE.inject.Component) && target(o)")
    public void inject(Object o) {
        ContainerKey key = ContainerKey.getKey(o.getClass());
        injectFieldsToClassHierarchy(o);
        caller.callPostConstructMethods(o);
        container.put(key, o);
    }

    @AfterReturning(value = "execution(* *.*(..)) && @annotation(pl.projectE.inject.Component)", returning = "o")
    public void putToContainer(Object o, JoinPoint joinPoint) {
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
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
        if (container.containsKey(key)) {
            setValueInField(field, o, container.get(key));
        } else {
            setValueInField(field, o, instantiateNewClass(field));
        }
    }

    @Nullable
    private Object instantiateNewClass(Field field) {
        try {
            Class<?> fieldType = field.getType();
            if(fieldType.isInterface()) {
                fieldType = field.getAnnotation(Implementation.class).specifiedClass();
            }
            return fieldType.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
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
