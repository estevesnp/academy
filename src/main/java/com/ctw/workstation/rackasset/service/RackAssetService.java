package com.ctw.workstation.rackasset.service;

import com.ctw.workstation.rackasset.entity.RackAsset;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class RackAssetService {
    public List<RackAsset> getAll() {
        return RackAsset.listAll();
    }

    public RackAsset getById(UUID id) {
        return RackAsset.findById(id);
    }

    public RackAsset create(RackAsset item) {
        RackAsset.persist(item);
        return item;
    }

    public RackAsset modify(UUID id, RackAsset item) {
        RackAsset old = RackAsset.findById(id);
        if (old == null) {
            return null;
        }
        RackAsset.persist(item);
        return item;
    }

    public RackAsset remove(UUID id) {
        RackAsset toDel = RackAsset.findById(id);
        if (toDel == null) {
            return null;
        }

        RackAsset.deleteById(id);
        return toDel;
    }
}
