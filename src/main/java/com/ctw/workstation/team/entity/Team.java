package com.ctw.workstation.team.entity;

import com.ctw.workstation.domain.AbstractModel;
import com.ctw.workstation.domain.DefaultLocation;

import java.time.LocalDate;

public class Team extends AbstractModel {
    private String name;
    private String product;
    private DefaultLocation defaultLocation;
    private LocalDate createdAt;
    private LocalDate modifiedAt;

    public String getName() {
        return name;
    }

    public String getProduct() {
        return product;
    }

    public DefaultLocation getDefaultLocation() {
        return defaultLocation;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getModifiedAt() {
        return modifiedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setDefaultLocation(DefaultLocation defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(LocalDate modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
