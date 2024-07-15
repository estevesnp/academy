package com.ctw.workstation.teammember.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public record TeamMemberDTO(UUID getId, LocalDateTime getCreatedAt,
                            LocalDateTime getModifiedAt, String getCtwId,
                            String getName, UUID getTeamId) {
}