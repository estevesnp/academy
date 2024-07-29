package com.ctw.workstation.team.boundary;

import com.ctw.workstation.exceptions.EntityNotFoundException;
import com.ctw.workstation.team.control.TeamService;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamDTO;
import com.ctw.workstation.team.entity.TeamMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Transactional
@Path("/workstation/teams")
public class TeamResource {

    @Inject
    TeamService service;

    @GET
    public List<TeamDTO> getTeams() {
        return service.getAll().stream()
                .map(TeamMapper::domainToDTO)
                .toList();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") UUID id) {
        try {
            Team team = service.getById(id);
            return Response.status(200)
                    .entity(TeamMapper.domainToDTO(team))
                    .build();

        } catch (EntityNotFoundException e) {
            return Response.status(404, e.getMessage()).build();
        }
    }

    @POST
    public Response postTeam(@Valid TeamDTO teamDTO) {
        Team team = service.create(TeamMapper.dtoToDomain(teamDTO));
        return Response.status(201)
                .entity(TeamMapper.domainToDTO(team))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTeam(@PathParam("id") UUID id, @Valid TeamDTO teamDTO) {
        try {
            Team updated = service.modify(id, TeamMapper.dtoToDomain(teamDTO));
            return Response.status(201)
                    .entity(TeamMapper.domainToDTO(updated))
                    .build();

        } catch (EntityNotFoundException e) {
            return Response.status(404, e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTeam(@PathParam("id") UUID id) {
        try {
            service.remove(id);
            return Response.status(200).build();
        } catch (EntityNotFoundException e) {
            return Response.status(410, e.getMessage()).build();
        }
    }
}
