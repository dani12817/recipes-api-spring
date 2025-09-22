package com.recipes.api.spring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.recipes.api.spring.dto.RecipeListReadDto;
import com.recipes.api.spring.dto.RecipeReadDto;
import com.recipes.api.spring.dto.RecipeWriteDto;
import com.recipes.api.spring.entity.Recipe;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN )
public interface RecipeMapper extends BaseMapper<Recipe, RecipeReadDto, RecipeListReadDto, RecipeWriteDto> {
}
