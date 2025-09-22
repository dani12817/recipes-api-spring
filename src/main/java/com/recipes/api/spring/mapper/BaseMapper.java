package com.recipes.api.spring.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.recipes.api.spring.dto.BaseDto;
import com.recipes.api.spring.entity.BaseEntity;

import java.util.List;

@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BaseMapper<E extends BaseEntity, R extends BaseDto, L, W> {

    R entityToDto(E entity);

    E dtoToEntity(W dto);

    L entityToListDto(E entity);

    List<L> entityToListDto(Iterable<E> entityIterable);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(W dto, @MappingTarget E entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(E updated, @MappingTarget E entity);

}
