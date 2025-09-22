package com.recipes.api.spring.entity;

import java.io.Serial;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Recipe extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 6328639096330581927L;

    @NotNull
    private String title;

    @NotNull
    private String makingTime;

    @NotNull
    private String serves;

    @NotNull
    private String ingredients;

    @NotNull
    private Integer cost;


}
