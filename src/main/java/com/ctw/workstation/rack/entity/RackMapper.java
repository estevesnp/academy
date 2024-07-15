package com.ctw.workstation.rack.entity;

public class RackMapper {
    public static Rack dtoToDomain(RackDTO dto) {
        Rack rack = new Rack();

        rack.setId(dto.getId());
        rack.setCreatedAt(dto.getCreatedAt());
        rack.setModifiedAt(dto.getModifiedAt());
        rack.setSerialNumber(dto.getSerialNumber());
        rack.setStatus(dto.getStatus());
        rack.setTeamId(dto.getTeamId());

        return rack;
    }

    public static RackDTO domainToDTO(Rack rack) {
        return new RackDTO(rack.getId(), rack.getCreatedAt(),
                rack.getModifiedAt(), rack.getSerialNumber(),
                rack.getStatus(), rack.getTeamId());
    }
}
