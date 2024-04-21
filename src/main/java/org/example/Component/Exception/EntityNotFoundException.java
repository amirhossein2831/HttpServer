package org.example.Component.Exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {
        super("the Entity was not found");
    }
}
