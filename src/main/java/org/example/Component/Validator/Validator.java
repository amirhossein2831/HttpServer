package org.example.Component.Validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import org.example.Component.Model.Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Validator {
    public static final jakarta.validation.Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    public static Map<String, String> validate(Model record) {
        Map<String, String> errors = new HashMap<>();
        Set<ConstraintViolation<Model>> violations = validator.validate(record);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<Model> violation : violations) {
                errors.put(violation.getPropertyPath().toString(), violation.getMessage());
            }
        }
        return errors;
    }
}
