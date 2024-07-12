package com.ctw.workstation.domain;

import com.ctw.workstation.model.AbstractModel;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import java.util.List;
import java.util.UUID;

public abstract class AbstractRepository<T extends AbstractModel> implements PanacheRepositoryBase<T, UUID>, Repository<T> {
    @Override
    public List<T> getAll() {
        return listAll();
    }

    @Override
    public T getById(UUID id) {
        return findById(id);
    }

    @Override
    public T create(T item) {
        persist(item);
        return item;
    }

    @Override
    public T modify(UUID id, T item) {

        T old = findById(id);
        if (old == null) {
            return null;
        }
        persist(item);
        return item;
    }

    @Override
    public T remove(UUID id) {
        T toDel = findById(id);
        if (toDel == null) {
            return null;
        }

        deleteById(id);
        return toDel;
    }
}
