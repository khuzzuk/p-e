package pl.projectE.inject;

import com.sun.istack.internal.Nullable;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import javax.inject.Inject;
import java.lang.reflect.Field;

@Aspect
public class Injector {
    private MultiValuedMap<ContainerKey, Object> container = new HashSetValuedHashMap<>();

    @After("execution(*.new(..)) && @within(pl.projectE.inject.Component) && target(o)")
    public void inject(Object o) {
        ContainerKey key = ContainerKey.getKey(o.getClass());
        injectFieldsToClassHierarchy(o);
        container.put(key, o);
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
        if (container.containsKey(key))
            setValueInField(field, o, container.get(key));
        else setValueInField(field, o, instantiateNewClass(field));
    }

    @Nullable
    private Object instantiateNewClass(Field field) {
        try {
            Class<?> declaredClass = field.getType();
            return declaredClass.newInstance();
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
