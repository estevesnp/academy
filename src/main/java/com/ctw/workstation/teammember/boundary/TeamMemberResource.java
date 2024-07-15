package com.ctw.workstation.teammember.boundary;

import com.ctw.workstation.exceptions.EntityNotFoundException;
import com.ctw.workstation.teammember.control.TeamMemberService;
import com.ctw.workstation.teammember.entity.TeamMember;
import com.ctw.workstation.teammember.entity.TeamMemberDTO;
import com.ctw.workstation.teammember.entity.TeamMemberMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Transactional
@Path("/workstation/teammembers")
public class TeamMemberResource {

    @Inject
    TeamMemberService service;

    @GET
    public List<TeamMemberDTO> getTeamMembers() {
        return service.getAll().stream()
                .map(TeamMemberMapper::domainToDTO)
                .toList();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") UUID id) {
        try {
            TeamMember teamMember = service.getById(id);
            return Response.status(200)
                    .entity(TeamMemberMapper.domainToDTO(teamMember))
                    .build();

        } catch (EntityNotFoundException e) {
            return Response.status(404, e.getMessage()).build();
        }
    }

    @POST
    public Response postTeamMember(TeamMemberDTO teamMemberDTO) {
        TeamMember teamMember = service.create(TeamMemberMapper.dtoToDomain(teamMemberDTO));
        return Response.status(201)
                .entity(TeamMemberMapper.domainToDTO(teamMember))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTeamMember(@PathParam("id") UUID id, TeamMemberDTO memberDTO) {
        try {
            TeamMember updated = service.modify(id, TeamMemberMapper.dtoToDomain(memberDTO));
            return Response.status(200)
                    .entity(TeamMemberMapper.domainToDTO(updated))
                    .build();

        } catch (EntityNotFoundException e) {
            return Response.status(404, e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTeamMember(@PathParam("id") UUID id) {
        try {
            service.remove(id);
            return Response.status(200).build();
        } catch (EntityNotFoundException e) {
            return Response.status(410, e.getMessage()).build();
        }
    }

}
