package com.recipes.api.spring.controller;

import com.recipes.api.spring.dto.BaseDto;
import com.recipes.api.spring.entity.BaseEntity;
import com.recipes.api.spring.mapper.BaseMapper;
import com.recipes.api.spring.service.BaseQueryService;
import com.recipes.api.spring.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController<E extends BaseEntity, R extends BaseDto, L, W> {

    @Autowired
    protected BaseQueryService<E> baseQueryService;

    @Autowired
    protected BaseService<E, W> baseService;

    @Autowired
    protected BaseMapper<E, R, L, W> baseMapper;

}
