package com.recipes.api.spring.service;

import com.recipes.api.spring.entity.BaseEntity;
import com.recipes.api.spring.mapper.BaseMapper;
import com.recipes.api.spring.repository.BaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;

@Transactional(readOnly = true)
public abstract class BaseService<E extends BaseEntity, W> {

    @Autowired
    protected BaseRepository<E> baseRepository;

    @Autowired
    protected BaseMapper<E, ?, ?, W> baseMapper;

    @Autowired
    protected BaseQueryService<E> baseQueryService;

    @Autowired
    protected EntityManager em;

    protected void preSave(W dto) {
    }

    protected void preUpdate(Integer id, W dto) {
    }

    @Transactional
    public E create(W dto) {
        this.preSave(dto);

        var entity = this.baseMapper.dtoToEntity(dto);
        entity = this.baseRepository.save(entity);

        return entity;
    }

    @Transactional
    public E update(Integer id, W updatedEntity) {
        this.preUpdate(id, updatedEntity);

        var entity = this.baseQueryService.getById(id);

        this.baseMapper.updateEntity(updatedEntity, entity);
        entity = this.baseRepository.save(entity);
        this.em.flush();

        return entity;
    }

    @Transactional
    public void deleteById(Integer id) {
        var entity = this.baseQueryService.getById(id);
        this.baseRepository.delete(entity);
    }
}
