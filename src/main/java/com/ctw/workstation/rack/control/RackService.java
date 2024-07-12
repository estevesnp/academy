package com.ctw.workstation.rack.control;

import com.ctw.workstation.rack.entity.Rack;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class RackService {
    public List<Rack> getAll() {
        return Rack.listAll();
    }

    public Rack getById(UUID id) {
        return Rack.findById(id);
    }

    public Rack create(Rack item) {
        Rack.persist(item);
        return item;
    }

    public Rack modify(UUID id, Rack item) {
        Rack old = Rack.findById(id);
        if (old == null) {
            return null;
        }
        Rack.persist(item);
        return item;
    }

    public Rack remove(UUID id) {
        Rack toDel = Rack.findById(id);
        if (toDel == null) {
            return null;
        }

        Rack.deleteById(id);
        return toDel;
    }
}
