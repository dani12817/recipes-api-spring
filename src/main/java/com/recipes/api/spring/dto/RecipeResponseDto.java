package com.recipes.api.spring.dto;

import java.io.Serial;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecipeResponseDto extends BaseResponseDto {

    @Serial
    private static final long serialVersionUID = -7257393799086891097L;

    protected RecipeReadDto recipe;

}
