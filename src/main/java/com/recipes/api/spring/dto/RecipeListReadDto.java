package com.recipes.api.spring.dto;

import java.io.Serial;

import lombok.Data;

@Data
public class RecipeListReadDto extends BaseDto {

    @Serial
    private static final long serialVersionUID = -515394909585709309L;

    private String title;

    private String makingTime;

    private String serves;

    private String ingredients;

    private Integer cost;

}
