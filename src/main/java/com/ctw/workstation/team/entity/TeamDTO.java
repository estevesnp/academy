package com.ctw.workstation.team.entity;

import com.ctw.workstation.domainentity.DefaultLocation;

import java.time.LocalDateTime;
import java.util.UUID;

public record TeamDTO(UUID getId, LocalDateTime getCreatedAt,
                      LocalDateTime getModifiedAt, String getName,
                      String getProduct, DefaultLocation getDefaultLocation) {
}
