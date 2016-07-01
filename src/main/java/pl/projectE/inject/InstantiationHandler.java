package pl.projectE.inject;

import com.sun.istack.internal.Nullable;
import pl.projectE.inject.qualifiers.Implementation;

import java.lang.reflect.Field;

class InstantiationHandler {
    @Nullable
    Object instantiateNewClass(Field field) {
        try {
            Class<?> fieldType = field.getType();
            if(fieldType.isInterface()) {
                if (!field.isAnnotationPresent(Implementation.class))
                    throw new InjectingInterfaceException("No implementation specified");
                fieldType = field.getAnnotation(Implementation.class).specifiedClass();
            }
            return fieldType.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
