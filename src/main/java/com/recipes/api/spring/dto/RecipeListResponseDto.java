package com.recipes.api.spring.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecipeListResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 635998803458782868L;

    protected List<RecipeListReadDto> recipes;

}
