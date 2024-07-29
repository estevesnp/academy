package com.ctw.workstation.rack.control;

import com.ctw.workstation.exceptions.EntityNotFoundException;
import com.ctw.workstation.rack.boundary.RackRepository;
import com.ctw.workstation.rack.entity.Rack;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class RackService {

    @Inject
    RackRepository repo;

    public List<Rack> getAll() {
        return repo.listAll();
    }

    public Rack getById(UUID id) throws EntityNotFoundException {
        Rack rack = repo.findById(id);
        if (rack == null) {
            throw new EntityNotFoundException("Rack not found");
        }
        return rack;
    }

    public Rack create(Rack item) {
        repo.persist(item);
        return item;
    }

    public Rack modify(UUID id, Rack item) throws EntityNotFoundException {
        Rack rack = repo.findById(id);
        if (rack == null) {
            throw new EntityNotFoundException("Rack not found");
        }
        rack.setSerialNumber(item.getSerialNumber());
        rack.setStatus(item.getStatus());
        rack.setTeamId(item.getTeamId());
        return rack;
    }

    public void remove(UUID id) throws EntityNotFoundException {
        if (!repo.deleteById(id)) {
            throw new EntityNotFoundException("Rack not found");
        }
    }
}
