package com.ctw.workstation.teammember.entity;

public class TeamMemberMapper {
    public static TeamMember dtoToDomain(TeamMemberDTO dto) {
        TeamMember member = new TeamMember();

        member.setId(dto.getId());
        member.setCtwId(dto.getCtwId());
        member.setName(dto.getName());
        member.setTeamId(dto.getTeamId());

        return member;
    }

    public static TeamMemberDTO domainToDTO(TeamMember member) {
        return new TeamMemberDTO(member.getId(), member.getCtwId(),
                member.getName(), member.getTeamId());
    }
}