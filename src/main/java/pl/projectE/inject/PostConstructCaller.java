package pl.projectE.inject;

import javax.annotation.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


class PostConstructCaller {


    void callPostConstructMethods(Object o) {
        Class<?> objectClass = o.getClass();
        Method[] methods = objectClass.getDeclaredMethods();
        for (Method m : methods) {
            if (isMarkedPostConstruct(m)) {
                invokeMethod(o, m);
            }
        }
    }

    private void invokeMethod(Object o, Method m) {
        if (m.getParameterCount()!=0) throw new InvocationWithWrongParameterException();
        try {
            m.setAccessible(true);
            m.invoke(o);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private boolean isMarkedPostConstruct(Method method) {
        for (Annotation a : method.getDeclaredAnnotations()) {
            if (a instanceof PostConstruct) {
                return true;
            }
        }
        return false;
    }
}
