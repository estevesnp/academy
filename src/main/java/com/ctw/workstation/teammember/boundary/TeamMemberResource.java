package com.ctw.workstation.teammember.boundary;

import com.ctw.workstation.teammember.control.TeamMemberService;
import com.ctw.workstation.teammember.entity.TeamMember;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;

import java.util.List;
import java.util.UUID;

@Transactional
@Path("/workstation/teammembers")
public class TeamMemberResource {

    @Inject
    TeamMemberService service;

    @GET
    public List<TeamMember> getTeamMembers() {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    public TeamMember getById(@PathParam("id") UUID id) {
        TeamMember teamMember = service.getById(id);

        if (teamMember == null) {
            throw new NotFoundException();
        }

        return teamMember;
    }

    @POST
    public TeamMember postTeamMember(TeamMember teamMember) {
        return service.create(teamMember);
    }

    @PUT
    @Path("/{id}")
    public TeamMember updateTeamMember(@PathParam("id") UUID id, TeamMember teamMember) {
        TeamMember updated = service.modify(id, teamMember);
        if (updated == null) {
            throw new NotFoundException();
        }
        return updated;
    }

    @DELETE
    @Path("/{id}")
    public TeamMember deleteTeamMember(@PathParam("id") UUID id) {
        TeamMember deleted = service.remove(id);

        if (deleted == null) {
            throw new NotFoundException();
        }

        return deleted;
    }

}
