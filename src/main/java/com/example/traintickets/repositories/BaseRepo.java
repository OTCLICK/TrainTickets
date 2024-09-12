package com.example.traintickets.repositories;

import com.example.traintickets.entities.BaseEntity;
import com.example.traintickets.entities.Train;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public abstract class BaseRepo<Entity> {

    private final Class<Entity> entityClass;

    public BaseRepo(Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }

    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    public void save(Entity entity) {
        entityManager.persist(entity);
    }

    @Transactional
    public void update(Entity entity) {
        entityManager.merge(entity);
    }

//    @Transactional
//    public Entity save(Entity entity) {
//        entityManager.persist(entity);
//    }

//    @Transactional
//    public Entity save(Entity entity) {
//        if (entity.getId() == 0) {
//            entityManager.persist(entity);
//        } else {
//            entityManager.merge(entity);
//        }
//        return entity;
//    }
}

