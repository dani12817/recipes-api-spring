package com.recipes.api.spring.service;


import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;

import com.recipes.api.spring.entity.BaseEntity;
import com.recipes.api.spring.repository.BaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public abstract class BaseQueryService<E extends BaseEntity> {

    @Autowired
    protected BaseRepository<E> baseRepository;

    public List<E> getAll() {
        return (List<E>) this.baseRepository.findAll();
    }

    public E getById(Integer id) {
        return this.getByIdGraph(id, this.baseRepository.getDetailGraph());
    }

    public E getById(Integer id, EntityGraph graph) {
        return this.getByIdGraph(id, graph);
    }

    private E getByIdGraph(Integer id, EntityGraph graph) {
        E result = null;

        result = this.baseRepository.findById(id)
                .orElseThrow(this.baseRepository::getNotFoundException);

        return result;
    }

    public long count() {
        return this.baseRepository.count();
    }

    public boolean existsById(Integer id) {
        return this.baseRepository.existsById(id);
    }

}
