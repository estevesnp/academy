package com.ctw.workstation.team.boundary;

import com.ctw.workstation.domain.Repository;
import com.ctw.workstation.team.entity.Team;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;

import java.util.List;
import java.util.UUID;

@Transactional
@Path("/workstation/teams")
public class TeamResource {

    @Inject
    private Repository<Team> repo;

    @GET
    public List<Team> getTeams() {
        return repo.getAll();
    }

    @GET
    @Path("/{id}")
    public Team getById(@PathParam("id") UUID id) {
        Team team = repo.getById(id);

        if (team == null) {
            throw new NotFoundException();
        }

        return team;
    }

    @POST
    public Team postTeam(Team team) {
        return repo.create(team);
    }

    @PUT
    @Path("/{id}")
    public Team updateTeam(@PathParam("id") UUID id, Team team) {
        Team updated = repo.modify(id, team);

        if (updated == null) {
            throw new NotFoundException();
        }

        return updated;
    }

    @DELETE
    @Path("/{id}")
    public Team deleteTeam(@PathParam("id") UUID id) {
        Team deleted = repo.remove(id);

        if (deleted == null) {
            throw new NotFoundException();
        }

        return deleted;
    }
}
