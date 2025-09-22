package com.recipes.api.spring.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public abstract class BaseDto implements Serializable {

    protected Integer id;

}
