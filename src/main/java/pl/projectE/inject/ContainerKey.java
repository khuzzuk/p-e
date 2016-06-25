package pl.projectE.inject;

import javax.inject.Qualifier;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class ContainerKey {
    private Class<?> componentClass;
    private List<Qualifier> qualifiers = new ArrayList<>();

    ContainerKey(@NotNull Class<?> componentClass) {
        this.componentClass = componentClass;
    }

    void addQualifier(@NotNull Qualifier qualifier) {
        qualifiers.add(qualifier);
    }

    static ContainerKey getKey(Class<?> annotatedClass){
        return addQualifiers(new ContainerKey(annotatedClass), annotatedClass.getAnnotations());
    }

    static ContainerKey getKey(Field field) {
        return addQualifiers(new ContainerKey(field.getType()), field.getDeclaredAnnotations());
    }

    private static ContainerKey addQualifiers(final ContainerKey key, Annotation[] annotations) {
        for (Annotation a : annotations) {
            if (a instanceof Qualifier)
                key.addQualifier((Qualifier) a);
        }
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContainerKey that = (ContainerKey) o;

        if (componentClass != null ? !componentClass.equals(that.componentClass) : that.componentClass != null)
            return false;
        return qualifiers != null ? qualifiers.equals(that.qualifiers) : that.qualifiers == null;

    }

    @Override
    public int hashCode() {
        int result = componentClass != null ? componentClass.hashCode() : 0;
        result = 31 * result + (qualifiers != null ? qualifiers.hashCode() : 0);
        return result;
    }
}
