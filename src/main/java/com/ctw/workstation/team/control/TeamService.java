package com.ctw.workstation.team.control;

import com.ctw.workstation.exceptions.EntityNotFoundException;
import com.ctw.workstation.team.boundary.TeamRepository;
import com.ctw.workstation.team.entity.Team;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TeamService {

    @Inject
    TeamRepository repo;

    public List<Team> getAll() {
        return repo.listAll();
    }

    public Team getById(UUID id) throws EntityNotFoundException {
        Team team = repo.findById(id);
        if (team == null) {
            throw new EntityNotFoundException("Team not found");
        }
        return team;
    }

    public Team create(Team item) {
        repo.persist(item);
        return item;
    }

    public Team modify(UUID id, Team item) throws EntityNotFoundException {
        Team team = repo.findById(id);
        if (team == null) {
            throw new EntityNotFoundException("Team not found");
        }
        team.setName(item.getName());
        team.setProduct(item.getProduct());
        team.setDefaultLocation(item.getDefaultLocation());
        return team;
    }

    public void remove(UUID id) throws EntityNotFoundException {
        if (!repo.deleteById(id)) {
            throw new EntityNotFoundException("Team not found");
        }
    }
}
