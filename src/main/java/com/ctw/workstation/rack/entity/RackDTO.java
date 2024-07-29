package com.ctw.workstation.rack.entity;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record RackDTO(UUID getId,
                      @NotNull String getSerialNumber,
                      @NotNull RackStatus getStatus,
                      @NotNull UUID getTeamId) {
}
