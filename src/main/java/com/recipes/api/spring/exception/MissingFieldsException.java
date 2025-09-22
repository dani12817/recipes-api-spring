package com.recipes.api.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

import lombok.Getter;

@Getter
@ResponseStatus(HttpStatus.OK)
public class MissingFieldsException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 8188218939275428589L;

    private String required;

    public MissingFieldsException(String message, String required) {
        super(message);
        this.required = required;
    }

}
