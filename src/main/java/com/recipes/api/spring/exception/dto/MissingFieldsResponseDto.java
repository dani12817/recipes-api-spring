package com.recipes.api.spring.exception.dto;

import com.recipes.api.spring.dto.BaseResponseDto;

import java.io.Serial;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MissingFieldsResponseDto extends BaseResponseDto {

    @Serial
    private static final long serialVersionUID = -3513025184877879425L;

    private String required;

    public MissingFieldsResponseDto(String message, String required) {
        super(message);
        this.required = required;
    }

}
