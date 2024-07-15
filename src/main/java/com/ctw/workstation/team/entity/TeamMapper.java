package com.ctw.workstation.team.entity;

public class TeamMapper {
    public static Team dtoToDomain(TeamDTO dto) {
        Team team = new Team();

        team.setId(dto.getId());
        team.setProduct(dto.getProduct());
        team.setDefaultLocation(dto.getDefaultLocation());

        return team;
    }

    public static TeamDTO domainToDTO(Team team) {
        return new TeamDTO(team.getId(), team.getName(),
                team.getProduct(), team.getDefaultLocation());
    }
}
