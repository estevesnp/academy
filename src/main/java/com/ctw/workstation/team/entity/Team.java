package com.ctw.workstation.team.entity;

import com.ctw.workstation.domainentity.AbstractTimedModel;
import com.ctw.workstation.domainentity.DefaultLocation;
import jakarta.persistence.*;

@Entity
@Table(name = "t_team")
public class Team extends AbstractTimedModel {
    @Column(name = "name", length = 20, nullable = false)
    private String name;
    @Column(name = "product", length = 20, nullable = false)
    private String product;
    @Enumerated(EnumType.STRING)
    @Column(name = "default_location", nullable = false)
    private DefaultLocation defaultLocation;

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
}
