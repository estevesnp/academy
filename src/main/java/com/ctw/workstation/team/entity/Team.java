package com.ctw.workstation.team.entity;

import com.ctw.workstation.domain.AbstractModel;
import com.ctw.workstation.domain.DefaultLocation;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "t_team")
public class Team extends AbstractModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private UUID id;
    @Column(name = "name", length = 20, nullable = false)
    private String name;
    @Column(name = "product", length = 20, nullable = false)
    private String product;
    @Enumerated(EnumType.STRING)
    @Column(name = "default_location", nullable = false)
    private DefaultLocation defaultLocation;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at", nullable = true)
    private LocalDateTime modifiedAt;

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
