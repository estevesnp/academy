package com.ctw.workstation.rack.entity;

import com.ctw.workstation.domain.AbstractModel;
import com.ctw.workstation.domain.RackStatus;

import java.time.LocalDate;
import java.util.UUID;

public class Rack extends AbstractModel {

    private UUID teamId;
    private String serialNumber;
    private RackStatus status;
    private LocalDate createdAt;
    private LocalDate modifiedAt;

    public UUID getTeamId() {
        return teamId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public RackStatus getStatus() {
        return status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getModifiedAt() {
        return modifiedAt;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setStatus(RackStatus status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(LocalDate modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
