package com.recipes.api.spring.dto;

import java.io.Serial;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class RecipeReadDto extends BaseAuditDto {

    @Serial
    private static final long serialVersionUID = -6203240959702858460L;

    private String title;

    private String makingTime;

    private String serves;

    private String ingredients;

    private Integer cost;

}
