package com.ctw.workstation.rack.entity;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RackMapperTest {

    @Test
    void rackDtoToDomain() {
        UUID id = UUID.randomUUID();
        String serialNumber = "serialNumber";
        RackStatus status = RackStatus.AVAILABLE;
        UUID teamId = UUID.randomUUID();

        RackDTO dto = new RackDTO(id, serialNumber, status, teamId);


        Rack rack = RackMapper.dtoToDomain(dto);


        assertEquals(id, rack.getId(), "Verifying id is properly set");
        assertEquals(serialNumber, rack.getSerialNumber(), "Verifying serialNumber is properly set");
        assertEquals(status, rack.getStatus(), "Verifying status is properly set");
        assertEquals(teamId, rack.getTeamId(), "Verifying teamId is properly set");
    }

    @Test
    void rackDomainToDTO() {
        UUID id = UUID.randomUUID();
        String serialNumber = "serialNumber";
        RackStatus status = RackStatus.AVAILABLE;
        UUID teamId = UUID.randomUUID();

        Rack rack = new Rack();
        rack.setId(id);
        rack.setSerialNumber(serialNumber);
        rack.setStatus(status);
        rack.setTeamId(teamId);


        RackDTO dto = RackMapper.domainToDTO(rack);


        assertEquals(id, dto.getId(), "Verifying id is properly set");
        assertEquals(serialNumber, dto.getSerialNumber(), "Verifying serialNumber is properly set");
        assertEquals(status, dto.getStatus(), "Verifying status is properly set");
        assertEquals(teamId, dto.getTeamId(), "Verifying teamId is properly set");
    }
}