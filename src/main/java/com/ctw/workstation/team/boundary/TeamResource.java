package com.ctw.workstation.team.boundary;

import com.ctw.workstation.team.control.TeamService;
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
    TeamService service;

    @GET
    public List<Team> getTeams() {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    public Team getById(@PathParam("id") UUID id) {
        Team team = service.getById(id);

        if (team == null) {
            throw new NotFoundException();
        }

        return team;
    }

    @POST
    public Team postTeam(Team team) {
        return service.create(team);
    }

    @PUT
    @Path("/{id}")
    public Team updateTeam(@PathParam("id") UUID id, Team team) {
        Team updated = service.modify(id, team);

        if (updated == null) {
            throw new NotFoundException();
        }

        return updated;
    }

    @DELETE
    @Path("/{id}")
    public Team deleteTeam(@PathParam("id") UUID id) {
        Team deleted = service.remove(id);

        if (deleted == null) {
            throw new NotFoundException();
        }

        return deleted;
    }
}
