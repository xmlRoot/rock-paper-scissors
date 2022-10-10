package com.tyntec.interview.rps.common.persistence;

public interface CrudRepository<T extends PersistentEntity<ID>, ID> {
    T save(T entity);
    T findById(ID id);
    void delete(T entity);
    void deleteById(ID id);
}
