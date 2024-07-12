package com.ctw.workstation.teammember.entity;

import com.ctw.workstation.domain.AbstractModel;

import java.time.LocalDate;
import java.util.UUID;

public class TeamMember extends AbstractModel {
    private UUID teamId;
    private String ctwId;
    private String name;
    private LocalDate createdAt;
    private LocalDate modifiedAt;

    public UUID getTeamId() {
        return teamId;
    }

    public String getCtwId() {
        return ctwId;
    }

    public String getName() {
        return name;
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

    public void setCtwId(String ctwId) {
        this.ctwId = ctwId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(LocalDate modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
