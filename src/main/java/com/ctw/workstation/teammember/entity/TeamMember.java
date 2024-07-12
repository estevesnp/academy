package com.ctw.workstation.teammember.entity;

import com.ctw.workstation.domain.AbstractModel;
import com.ctw.workstation.team.entity.Team;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "t_team_member")
public class TeamMember extends AbstractModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private UUID id;
    @Column(name = "ctw_id", length = 20, nullable = false)
    private String ctwId;
    @Column(name = "name", length = 20, nullable = false)
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at", nullable = true)
    private LocalDateTime modifiedAt;
    @Column(name = "team_id", nullable = false)
    private UUID teamId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", updatable = false, insertable = false, nullable = false)
    private Team team;

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
