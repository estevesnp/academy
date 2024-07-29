package com.ctw.workstation.teammember.entity;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record TeamMemberDTO(UUID getId,
                            @NotNull String getCtwId,
                            @NotNull String getName,
                            @NotNull UUID getTeamId) {
}