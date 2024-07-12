package com.ctw.workstation.rackasset.entity;

import com.ctw.workstation.domain.AbstractModel;

import java.util.UUID;

public class RackAsset extends AbstractModel {
    private UUID rackId;
    private String assetTag;

    public UUID getRackId() {
        return rackId;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }
}
