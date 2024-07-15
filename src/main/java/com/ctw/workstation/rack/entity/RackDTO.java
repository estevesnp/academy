package com.ctw.workstation.rack.entity;

import java.util.UUID;

public record RackDTO(UUID getId, String getSerialNumber,
                      RackStatus getStatus, UUID getTeamId) {
}
