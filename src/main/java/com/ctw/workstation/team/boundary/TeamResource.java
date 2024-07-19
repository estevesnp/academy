package com.ctw.workstation.team.boundary;

import com.ctw.workstation.exceptions.EntityNotFoundException;
import com.ctw.workstation.external.ExternalApi;
import com.ctw.workstation.external.ExternalRequest;
import com.ctw.workstation.team.control.TeamService;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamDTO;
import com.ctw.workstation.team.entity.TeamMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.UUID;

@Transactional
@Path("/workstation/teams")
public class TeamResource {

    @Inject
    TeamService service;

    @RestClient
    ExternalApi externalApi;

    @GET
    public List<TeamDTO> getTeams() {
        return service.getAll().stream()
                .map(TeamMapper::domainToDTO)
                .toList();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") UUID id) {
        externalApi.hello(new ExternalRequest(id.toString()));
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
    public Response postTeam(TeamDTO teamDTO) {
        Team team = service.create(TeamMapper.dtoToDomain(teamDTO));
        return Response.status(201)
                .entity(TeamMapper.domainToDTO(team))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTeam(@PathParam("id") UUID id, TeamDTO teamDTO) {
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
