package com.starwars.api.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String err) {
        super(err);
    }
}
