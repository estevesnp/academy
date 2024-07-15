package com.ctw.workstation.rack.entity;

import com.ctw.workstation.domainentity.RackStatus;

import java.util.UUID;

public record RackDTO(UUID getId, String getSerialNumber,
                      RackStatus getStatus, UUID getTeamId) {
}
