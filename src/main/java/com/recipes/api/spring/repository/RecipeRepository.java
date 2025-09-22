package com.recipes.api.spring.repository;

import com.recipes.api.spring.entity.Recipe;

public interface RecipeRepository extends BaseRepository<Recipe> {

    @Override
    default String getType() {
        return Recipe.class.getSimpleName().toLowerCase();
    }

}
