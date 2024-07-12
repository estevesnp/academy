package com.ctw.workstation.rackasset.entity;

import com.ctw.workstation.domain.AbstractModel;

import java.util.UUID;

public class RackAsset extends AbstractModel {
    private UUID id;
    private UUID rackId;
    private String assetTag;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getRackId() {
        return rackId;
    }

    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }
}
