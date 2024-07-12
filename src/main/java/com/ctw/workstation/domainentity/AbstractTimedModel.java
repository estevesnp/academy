package com.ctw.workstation.domainentity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@MappedSuperclass
public class AbstractTimedModel extends AbstractModel {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at", nullable = true)
    private LocalDateTime modifiedAt;

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

    @PrePersist
    private void setCreatedTimeOnPersist() {
        this.setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    private void updateModifiedTimeOnUpdate() {
        this.setModifiedAt(LocalDateTime.now());
    }
}
