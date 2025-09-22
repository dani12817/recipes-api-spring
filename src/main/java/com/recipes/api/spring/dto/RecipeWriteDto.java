package com.recipes.api.spring.dto;

import java.io.Serial;
import java.io.Serializable;

import lombok.Data;

@Data
public class RecipeWriteDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -1359515044503895233L;

    private String title;

    private String makingTime;

    private String serves;

    private String ingredients;

    private Integer cost;

}
