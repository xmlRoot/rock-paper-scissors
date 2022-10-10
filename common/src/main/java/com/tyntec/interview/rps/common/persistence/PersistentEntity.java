package com.tyntec.interview.rps.common.persistence;

public interface PersistentEntity<ID> {
    ID getId();
    void setId(ID id);
}
