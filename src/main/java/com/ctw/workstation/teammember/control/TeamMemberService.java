package com.ctw.workstation.teammember.control;

import com.ctw.workstation.teammember.boundary.TeamMemberRepository;
import com.ctw.workstation.teammember.entity.TeamMember;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TeamMemberService {

    @Inject
    TeamMemberRepository repo;

    public List<TeamMember> getAll() {
        return repo.listAll();
    }

    public TeamMember getById(UUID id) {
        TeamMember member = repo.findById(id);
        if (member == null) {
            throw new EntityNotFoundException("Team Member not found");
        }
        return member;
    }

    public TeamMember create(TeamMember item) {
        repo.persist(item);
        return item;
    }

    public TeamMember modify(UUID id, TeamMember item) throws EntityNotFoundException {
        TeamMember member = repo.findById(id);
        if (member == null) {
            throw new EntityNotFoundException("Team Member not found");
        }
        member.setName(item.getName());
        member.setCtwId(item.getCtwId());
        member.setTeamId(item.getTeamId());
        return member;
    }

    public void remove(UUID id) throws EntityNotFoundException {
        if (!repo.deleteById(id)) {
            throw new EntityNotFoundException("Team Member not found");
        }
    }
}
