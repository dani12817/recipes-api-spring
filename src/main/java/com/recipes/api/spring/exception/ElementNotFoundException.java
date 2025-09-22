package com.recipes.api.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ElementNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 5133948888336151382L;

    public ElementNotFoundException(String message) {
        super(message);
    }
}
