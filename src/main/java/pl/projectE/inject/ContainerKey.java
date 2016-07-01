package pl.projectE.inject;

import javax.inject.Named;
import javax.inject.Qualifier;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class ContainerKey {
    private final Class<?> componentClass;
    private final List<String> qualifiers = new ArrayList<>();

    ContainerKey(@NotNull Class<?> componentClass) {
        this.componentClass = componentClass;
    }

    void addQualifier(@NotNull Class<? extends Annotation> qualifier) {
        qualifiers.add(qualifier.toString());
    }
    void addName(@NotNull Named name) {
        qualifiers.add(name.value());
    }

    static ContainerKey getKey(Class<?> annotatedClass) {
        ContainerKey key = new ContainerKey(annotatedClass);
        return key.addQualifiers(annotatedClass.getAnnotations());
    }

    static ContainerKey getKey(Field field) {
        ContainerKey key = new ContainerKey(field.getType());
        key.addQualifiers(field.getDeclaredAnnotations());
        return key;
    }

    static ContainerKey getKey(Method method) {
        ContainerKey key = new ContainerKey(method.getReturnType());
        key.addQualifiers(method.getDeclaredAnnotations());
        return key;
    }

    private ContainerKey addQualifiers(Annotation[] annotations) {
        for (Annotation a : annotations) {
            if (a instanceof Named)
                addName((Named) a);
            else addQualifiedAnnotations(a);
        }
        return this;
    }

    private void addQualifiedAnnotations(Annotation annotation) {
        if (hasQualifier(annotation.annotationType().getDeclaredAnnotations()))
            addQualifier(annotation.annotationType());
    }

    private boolean hasQualifier(Annotation[] annotations) {
        for (Annotation a : annotations)
            if (a instanceof Qualifier) return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContainerKey that = (ContainerKey) o;

        return componentClass != null ? componentClass.equals(that.componentClass) : that.componentClass == null && qualifiers.equals(that.qualifiers);

    }

    @Override
    public int hashCode() {
        int result = componentClass != null ? componentClass.hashCode() : 0;
        result = 31 * result + qualifiers.hashCode();
        return result;
    }
}
