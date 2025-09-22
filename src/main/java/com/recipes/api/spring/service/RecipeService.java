package com.recipes.api.spring.service;

import com.recipes.api.spring.dto.RecipeWriteDto;
import com.recipes.api.spring.entity.Recipe;
import com.recipes.api.spring.exception.MissingFieldsException;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService extends BaseService<Recipe, RecipeWriteDto> {

    @Override
    protected void preSave(RecipeWriteDto dto) {
        this.checkMissingFields(null, dto);
    }

    @Override
    protected void preUpdate(Integer id, RecipeWriteDto dto) {
        this.checkMissingFields(id, dto);
    }

    private void checkMissingFields(Integer id, RecipeWriteDto dto) throws MissingFieldsException {
        List<String> missingFields = new ArrayList<>();

        if (!StringUtils.hasLength(dto.getTitle()))
            missingFields.add("title");

        if (!StringUtils.hasLength(dto.getMakingTime()))
            missingFields.add("makingTime");

        if (!StringUtils.hasLength(dto.getServes()))
            missingFields.add("serves");

        if (!StringUtils.hasLength(dto.getIngredients()))
            missingFields.add("ingredients");

        if (dto.getCost() == null)
            missingFields.add("cost");

        if (!missingFields.isEmpty()) {
            throw new MissingFieldsException(String.format("Recipe %s failed!", id != null ? "update" : "creation"), String.join(", ", missingFields));
        }
    }

}
