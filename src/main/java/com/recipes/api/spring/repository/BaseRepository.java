package com.recipes.api.spring.repository;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphRepository;

import com.recipes.api.spring.entity.BaseEntity;
import com.recipes.api.spring.exception.ElementNotFoundException;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity>
        extends CrudRepository<E, Integer>, EntityGraphRepository<E, Integer> {

    String getType();

    default E map(Integer id) {
        E result = null;

        if (id != null) {
            result = this.findById(id).orElseThrow(this::getNotFoundException);
        }

        return result;
    }

    default ElementNotFoundException getNotFoundException() {
        return new ElementNotFoundException(getType());
    }

    default EntityGraph getDetailGraph() {
        return EntityGraph.NOOP;
    }

    default EntityGraph getListGraph() {
        return EntityGraph.NOOP;
    }

}
