package com.ctw.workstation.team.entity;

import com.ctw.workstation.entity.DefaultLocation;

import java.util.UUID;

public record TeamDTO(UUID getId, String getName,
                      String getProduct, DefaultLocation getDefaultLocation) {
}
