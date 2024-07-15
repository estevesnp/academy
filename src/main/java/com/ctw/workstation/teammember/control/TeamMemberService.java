package com.ctw.workstation.teammember.control;

import com.ctw.workstation.exceptions.EntityNotFoundException;
import com.ctw.workstation.teammember.entity.TeamMember;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TeamMemberService {
    public List<TeamMember> getAll() {
        return TeamMember.listAll();
    }

    public TeamMember getById(UUID id) throws EntityNotFoundException {
        TeamMember member = TeamMember.findById(id);
        if (member == null) {
            throw new EntityNotFoundException("Team Member not found");
        }
        return member;
    }

    public TeamMember create(TeamMember item) {
        TeamMember.persist(item);
        return item;
    }

    public TeamMember modify(UUID id, TeamMember item) throws EntityNotFoundException {
        if (TeamMember.findById(id) == null) {
            throw new EntityNotFoundException("Team Member not found");
        }
        TeamMember.persist(item);
        return item;
    }

    public void remove(UUID id) throws EntityNotFoundException {
        if (!TeamMember.deleteById(id)) {
            throw new EntityNotFoundException("Team Member not found");
        }
    }
}
