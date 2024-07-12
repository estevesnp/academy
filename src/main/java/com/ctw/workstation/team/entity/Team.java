package com.ctw.workstation.team.entity;

import com.ctw.workstation.domain.AbstractModel;
import com.ctw.workstation.domain.DefaultLocation;

import java.time.LocalDate;
import java.util.UUID;

public class Team extends AbstractModel {
    private UUID id;
    private String name;
    private String product;
    private DefaultLocation defaultLocation;
    private LocalDate createdAt;
    private LocalDate modifiedAt;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public DefaultLocation getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(DefaultLocation defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDate modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
