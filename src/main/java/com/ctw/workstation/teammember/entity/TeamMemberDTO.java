package com.ctw.workstation.teammember.entity;

import java.util.UUID;

public record TeamMemberDTO(UUID getId, String getCtwId,
                            String getName, UUID getTeamId) {
}