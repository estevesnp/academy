package com.ctw.workstation.domain;

import com.ctw.workstation.model.AbstractModel;

import java.util.List;
import java.util.UUID;

public interface Repository<T extends AbstractModel> {

    List<T> getAll();

    T getById(UUID id);

    T create(T item);

    T modify(UUID id, T item);

    T remove(UUID id);
}
