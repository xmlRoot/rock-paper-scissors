package com.tyntec.interview.rps.common.persistence;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseInMemoryRepository<T extends PersistentEntity<ID>, ID>
        implements CrudRepository<T, ID> {

    private final Map<ID, T> db = new HashMap<>();

    @Override
    public T save(T entity) {
        db.put(entity.getId(), entity);
        return entity;
    }
    @Override
    public T findById(ID id) {
        return db.get(id);
    }
    @Override
    public void delete(T entity) {
        deleteById(entity.getId());
    }
    @Override
    public void deleteById(ID id) {
        db.remove(id);
    }
}
