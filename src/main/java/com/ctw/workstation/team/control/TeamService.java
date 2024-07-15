package com.ctw.workstation.team.control;

import com.ctw.workstation.exceptions.EntityNotFoundException;
import com.ctw.workstation.team.entity.Team;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TeamService {
    public List<Team> getAll() {
        return Team.listAll();
    }

    public Team getById(UUID id) throws EntityNotFoundException {
        Team team = Team.findById(id);
        if (team == null) {
            throw new EntityNotFoundException("Team not found");
        }
        return team;
    }

    public Team create(Team item) {
        Team.persist(item);
        return item;
    }

    public Team modify(UUID id, Team item) throws EntityNotFoundException {
        if (Team.findById(id) == null) {
            throw new EntityNotFoundException("Team not found");
        }
        Team.persist(item);
        return item;
    }

    public void remove(UUID id) throws EntityNotFoundException {
        if (!Team.deleteById(id)) {
            throw new EntityNotFoundException("Team not found");
        }
    }
}
