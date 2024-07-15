package com.ctw.workstation.rack.entity;

import com.ctw.workstation.entity.AbstractTimedEntity;
import com.ctw.workstation.team.entity.Team;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "t_rack")
public class Rack extends AbstractTimedEntity {
    @Column(name = "serial_number", length = 20, nullable = false)
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private RackStatus status;
    @Column(name = "team_id", nullable = true)
    private UUID teamId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", updatable = false, insertable = false, nullable = false)
    private Team team;

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
