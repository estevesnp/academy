package com.ctw.workstation.rack.entity;

import com.ctw.workstation.domain.AbstractModel;
import com.ctw.workstation.domain.RackStatus;

import java.time.LocalDate;
import java.util.UUID;

public class Rack extends AbstractModel {

    private UUID id;
    private UUID teamId;
    private String serialNumber;
    private RackStatus status;
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

    public UUID getTeamId() {
        return teamId;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public RackStatus getStatus() {
        return status;
    }

    public void setStatus(RackStatus status) {
        this.status = status;
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
