package com.ctw.workstation.teammember.entity;

import com.ctw.workstation.entity.AbstractTimedEntity;
import com.ctw.workstation.team.entity.Team;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "t_team_member")
public class TeamMember extends AbstractTimedEntity {
    @Column(name = "ctw_id", length = 20, nullable = false)
    private String ctwId;
    @Column(name = "getName", length = 20, nullable = false)
    private String name;
    @Column(name = "team_id", nullable = false)
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

    public String getCtwId() {
        return ctwId;
    }

    public void setCtwId(String ctwId) {
        this.ctwId = ctwId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
