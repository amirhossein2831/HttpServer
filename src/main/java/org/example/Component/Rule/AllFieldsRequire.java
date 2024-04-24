package org.example.Component.Rule;

import org.example.Component.Model.Model;

import java.lang.reflect.Field;

public interface AllFieldsRequire {
    public static boolean check(Model record) {
        Field[] fields = record.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            try {
                Object value = field.get(record);

                if (value == null || (value instanceof String && ((String) value).isEmpty())) {
                    return false;
                }
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }
        return true;
    }}
