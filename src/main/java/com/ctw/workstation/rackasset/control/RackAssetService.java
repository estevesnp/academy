package com.ctw.workstation.rackasset.control;

import com.ctw.workstation.exceptions.EntityNotFoundException;
import com.ctw.workstation.rackasset.entity.RackAsset;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class RackAssetService {
    public List<RackAsset> getAll() {
        return RackAsset.listAll();
    }

    public RackAsset getById(UUID id) throws EntityNotFoundException {
        RackAsset asset = RackAsset.findById(id);
        if (asset == null) {
            throw new EntityNotFoundException("Rack Asset not found");
        }
        return asset;
    }

    public RackAsset create(RackAsset item) {
        RackAsset.persist(item);
        return item;
    }

    public RackAsset modify(UUID id, RackAsset item) throws EntityNotFoundException {
        if (RackAsset.findById(id) == null) {
            throw new EntityNotFoundException("Rack Asset not found");
        }
        RackAsset.persist(item);
        return item;
    }

    public void remove(UUID id) throws EntityNotFoundException {
        if (!RackAsset.deleteById(id)) {
            throw new EntityNotFoundException("Rack Asset not found");
        }
    }
}
