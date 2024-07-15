package com.ctw.workstation.rack.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record RackDTO(@JsonProperty("id") UUID getId,
                      @JsonProperty(value = "serial_number", required = true) String getSerialNumber,
                      @JsonProperty(value = "status", required = true) RackStatus getStatus,
                      @JsonProperty(value = "team_id", required = true) UUID getTeamId) {
}
