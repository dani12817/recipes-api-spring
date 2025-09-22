package com.recipes.api.spring.controller;

import com.recipes.api.spring.dto.*;
import com.recipes.api.spring.entity.Recipe;
import com.recipes.api.spring.exception.ElementNotFoundException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/recipes", produces = MediaType.APPLICATION_JSON_VALUE)
public class RecipeController extends BaseController<Recipe, RecipeReadDto, RecipeListReadDto, RecipeWriteDto> {


    @GetMapping
    public RecipeListResponseDto getAll() {
        RecipeListResponseDto responseDto = new RecipeListResponseDto();
        responseDto.setRecipes(this.baseMapper.entityToListDto(this.baseQueryService.getAll()));
        return responseDto;
    }

    @PostMapping
    public RecipeResponseDto create(@RequestBody RecipeWriteDto dto) {
        RecipeResponseDto responseDto = new RecipeResponseDto();
        responseDto.setMessage("Recipe successfully created!");
        responseDto.setRecipe(this.baseMapper.entityToDto(this.baseService.create(dto)));
        return responseDto;
    }

    @GetMapping("/{id}")
    public RecipeResponseDto getById(@PathVariable Integer id) throws ElementNotFoundException {
        RecipeResponseDto responseDto = new RecipeResponseDto();
        responseDto.setMessage("Recipe details by id");
        responseDto.setRecipe(this.baseMapper.entityToDto(this.baseQueryService.getById(id)));
        return responseDto;
    }

    @PutMapping("/{id}")
    @PatchMapping("/{id}")
    public RecipeResponseDto updateById(@PathVariable Integer id, @RequestBody RecipeWriteDto dto)
            throws ElementNotFoundException {
        RecipeResponseDto responseDto = new RecipeResponseDto();
        responseDto.setMessage("Recipe successfully updated!");
        responseDto.setRecipe(this.baseMapper.entityToDto(this.baseService.update(id, dto)));
        return responseDto;
    }

    @DeleteMapping("/{id}")
    public BaseResponseDto deleteById(@PathVariable Integer id) throws ElementNotFoundException {
        BaseResponseDto responseDto = new BaseResponseDto();
        responseDto.setMessage("Recipe successfully removed!");
        this.baseService.deleteById(id);
        return responseDto;
    }

}
