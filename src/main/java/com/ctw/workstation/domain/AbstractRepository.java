package com.ctw.workstation.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public abstract class AbstractRepository<T extends AbstractModel> implements Repository<T> {

    private final Map<UUID, T> map = new HashMap<UUID, T>();

    @Override
    public List<T> getAll() {
        return map.values().stream().toList();
    }

    @Override
    public T getById(UUID id) {
        return map.get(id);
    }

    @Override
    public T create(T item) {
        map.put(item.getId(), item);
        return item;
    }

    @Override
    public T modify(UUID id, T item) {
        T old = map.get(id);
        if (old == null) {
            return null;
        }
        map.put(item.getId(), item);
        return item;
    }

    @Override
    public T remove(UUID id) {
        T item = map.get(id);
        map.put(id, null);
        return item;
    }
}
