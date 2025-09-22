package com.recipes.api.spring.exception;

import com.recipes.api.spring.dto.BaseResponseDto;
import com.recipes.api.spring.exception.dto.MissingFieldsResponseDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { MissingFieldsException.class })
    protected ResponseEntity<MissingFieldsResponseDto> handleMissingFields(MissingFieldsException ex, WebRequest request) {
        MissingFieldsResponseDto apiResponse = new MissingFieldsResponseDto(ex.getMessage(), ex.getRequired());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ExceptionHandler(value = { ElementNotFoundException.class })
    protected ResponseEntity<BaseResponseDto> handleElementNotFound(ElementNotFoundException ex, WebRequest request) {
        BaseResponseDto apiResponse = new BaseResponseDto(String.format("No %s found", ex.getMessage()));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
