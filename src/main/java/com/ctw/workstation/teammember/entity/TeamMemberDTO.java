package com.ctw.workstation.teammember.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record TeamMemberDTO(@JsonProperty("id") UUID getId,
                            @JsonProperty(value = "ctw_id", required = true) String getCtwId,
                            @JsonProperty(value = "name", required = true) String getName,
                            @JsonProperty(value = "team_id", required = true) UUID getTeamId) {
}