package com.ctw.workstation.team.entity;

import com.ctw.workstation.entity.DefaultLocation;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record TeamDTO(UUID id,
                      @NotNull String name,
                      @NotNull String product,
                      @NotNull DefaultLocation defaultLocation) {
}
