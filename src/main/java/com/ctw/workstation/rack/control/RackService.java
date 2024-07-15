package com.ctw.workstation.rack.control;

import com.ctw.workstation.exceptions.EntityNotFoundException;
import com.ctw.workstation.rack.entity.Rack;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class RackService {
    public List<Rack> getAll() {
        return Rack.listAll();
    }

    public Rack getById(UUID id) throws EntityNotFoundException {
        Rack rack = Rack.findById(id);
        if (rack == null) {
            throw new EntityNotFoundException("Rack not found");
        }
        return rack;
    }

    public Rack create(Rack item) {
        Rack.persist(item);
        return item;
    }

    public Rack modify(UUID id, Rack item) throws EntityNotFoundException {
        if (Rack.findById(id) == null) {
            throw new EntityNotFoundException("Rack not found");
        }
        Rack.persist(item);
        return item;
    }

    public void remove(UUID id) throws EntityNotFoundException {
        if (Rack.findById(id) == null) {
            throw new EntityNotFoundException("Rack not found");
        }

        Rack.deleteById(id);
    }
}
