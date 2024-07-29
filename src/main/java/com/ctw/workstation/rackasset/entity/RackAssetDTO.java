package com.ctw.workstation.rackasset.entity;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record RackAssetDTO(UUID getId,
                           @NotNull String getAssetTag,
                           @NotNull UUID getRackId) {
}
