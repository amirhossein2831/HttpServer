package org.example.Component.Model;

import java.lang.reflect.Field;
import java.util.Map;

public abstract class Model {
    public abstract Long getId();

    public abstract void setId(Long id);

    public static void update(Model entity, Map<String, Object> body) {
        body.forEach((k, v) -> {
            try {
                Field field = entity.getClass().getDeclaredField(k);
                field.setAccessible(true);
                field.set(entity, v);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        });
    }

}
