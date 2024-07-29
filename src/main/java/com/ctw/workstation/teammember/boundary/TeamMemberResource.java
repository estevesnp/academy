package com.ctw.workstation.teammember.boundary;

import com.ctw.workstation.teammember.control.TeamMemberService;
import com.ctw.workstation.teammember.entity.TeamMember;
import com.ctw.workstation.teammember.entity.TeamMemberDTO;
import com.ctw.workstation.teammember.entity.TeamMemberMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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
        TeamMember teamMember = service.getById(id);
        return Response.status(200)
                .entity(TeamMemberMapper.domainToDTO(teamMember))
                .build();

    }

    @POST
    public Response postTeamMember(@Valid TeamMemberDTO teamMemberDTO) {
        TeamMember teamMember = service.create(TeamMemberMapper.dtoToDomain(teamMemberDTO));
        return Response.status(201)
                .entity(TeamMemberMapper.domainToDTO(teamMember))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTeamMember(@PathParam("id") UUID id, @Valid TeamMemberDTO memberDTO) {
        TeamMember updated = service.modify(id, TeamMemberMapper.dtoToDomain(memberDTO));
        return Response.status(200)
                .entity(TeamMemberMapper.domainToDTO(updated))
                .build();

    }

    @DELETE
    @Path("/{id}")
    public Response deleteTeamMember(@PathParam("id") UUID id) {
        service.remove(id);
        return Response.status(200).build();
    }

}
