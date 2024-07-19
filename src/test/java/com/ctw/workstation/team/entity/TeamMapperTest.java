package com.ctw.workstation.team.entity;

import com.ctw.workstation.entity.DefaultLocation;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeamMapperTest {

    @Test
    void TeamDtoToDomain() {
        UUID id = UUID.randomUUID();
        String name = "name";
        String product = "product";
        DefaultLocation defaultLocation = DefaultLocation.LISBON;
        TeamDTO dto = new TeamDTO(id, name, product, defaultLocation);


        Team team = TeamMapper.dtoToDomain(dto);


        assertEquals(id, team.getId(), "Verifying id is properly set");
        assertEquals(name, team.getName(), "Verifying name is properly set");
        assertEquals(product, team.getProduct(), "Verifying product is properly set");
        assertEquals(defaultLocation, team.getDefaultLocation(), "Verifying defaultLocation is properly set");
    }

    @Test
    void TeamDomainToDTO() {
        UUID id = UUID.randomUUID();
        String name = "name";
        String product = "product";
        DefaultLocation defaultLocation = DefaultLocation.LISBON;

        Team team = new Team();
        team.setId(id);
        team.setName(name);
        team.setProduct(product);
        team.setDefaultLocation(defaultLocation);


        TeamDTO dto = TeamMapper.domainToDTO(team);


        assertEquals(id, dto.id(), "Verifying id is properly set");
        assertEquals(name, dto.name(), "Verifying name is properly set");
        assertEquals(product, dto.product(), "Verifying product is properly set");
        assertEquals(defaultLocation, dto.defaultLocation(), "Verifying defaultLocation is properly set");
    }
}