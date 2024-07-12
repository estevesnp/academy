package com.ctw.workstation.team.control;

import com.ctw.workstation.team.entity.Team;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TeamService {
    public List<Team> getAll() {
        return Team.listAll();
    }

    public Team getById(UUID id) {
        return Team.findById(id);
    }

    public Team create(Team item) {
        Team.persist(item);
        return item;
    }

    public Team modify(UUID id, Team item) {
        Team old = Team.findById(id);
        if (old == null) {
            return null;
        }
        Team.persist(item);
        return item;
    }

    public Team remove(UUID id) {
        Team toDel = Team.findById(id);
        if (toDel == null) {
            return null;
        }

        Team.deleteById(id);
        return toDel;
    }
}
