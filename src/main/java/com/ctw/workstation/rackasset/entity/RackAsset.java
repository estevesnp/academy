package com.ctw.workstation.rackasset.entity;

import com.ctw.workstation.model.AbstractModel;
import com.ctw.workstation.rack.entity.Rack;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "t_rack_asset")
public class RackAsset extends AbstractModel {
    @Column(name = "asset_tag", length = 10, nullable = false)
    private String assetTag;
    @Column(name = "rack_id", nullable = false)
    private UUID rackId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rack_id", updatable = false, insertable = false, nullable = false)
    private Rack rack;

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

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }
}
