package com.ctw.workstation.rack.entity;

import com.ctw.workstation.domainentity.RackStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record RackDTO(UUID getId, LocalDateTime getCreatedAt,
                      LocalDateTime getModifiedAt, String getSerialNumber,
                      RackStatus getStatus, UUID getTeamId) {
}
