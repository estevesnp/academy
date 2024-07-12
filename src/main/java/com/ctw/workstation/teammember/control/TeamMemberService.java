package com.ctw.workstation.teammember.control;

import com.ctw.workstation.teammember.entity.TeamMember;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TeamMemberService {
    public List<TeamMember> getAll() {
        return TeamMember.listAll();
    }

    public TeamMember getById(UUID id) {
        return TeamMember.findById(id);
    }

    public TeamMember create(TeamMember item) {
        TeamMember.persist(item);
        return item;
    }

    public TeamMember modify(UUID id, TeamMember item) {
        TeamMember old = TeamMember.findById(id);
        if (old == null) {
            return null;
        }
        TeamMember.persist(item);
        return item;
    }

    public TeamMember remove(UUID id) {
        TeamMember toDel = TeamMember.findById(id);
        if (toDel == null) {
            return null;
        }

        TeamMember.deleteById(id);
        return toDel;
    }
}
