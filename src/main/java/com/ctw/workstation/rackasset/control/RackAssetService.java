package com.ctw.workstation.rackasset.control;

import com.ctw.workstation.exceptions.EntityNotFoundException;
import com.ctw.workstation.rackasset.boundary.RackAssetRepository;
import com.ctw.workstation.rackasset.entity.RackAsset;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class RackAssetService {

    @Inject
    RackAssetRepository repo;

    public List<RackAsset> getAll() {
        return repo.listAll();
    }

    public RackAsset getById(UUID id) throws EntityNotFoundException {
        RackAsset asset = repo.findById(id);
        if (asset == null) {
            throw new EntityNotFoundException("Rack Asset not found");
        }
        return asset;
    }

    public RackAsset create(RackAsset item) {
        repo.persist(item);
        return item;
    }

    public RackAsset modify(UUID id, RackAsset item) throws EntityNotFoundException {
        RackAsset asset = repo.findById(id);
        if (asset == null) {
            throw new EntityNotFoundException("Rack Asset not found");
        }

        asset.setAssetTag(item.getAssetTag());
        asset.setRackId(item.getRackId());
        return asset;
    }

    public void remove(UUID id) throws EntityNotFoundException {
        if (!repo.deleteById(id)) {
            throw new EntityNotFoundException("Rack Asset not found");
        }
    }
}
