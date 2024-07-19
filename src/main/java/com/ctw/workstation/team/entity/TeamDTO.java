package com.ctw.workstation.team.entity;

import com.ctw.workstation.entity.DefaultLocation;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record TeamDTO(@JsonProperty("id") UUID id,
                      @JsonProperty(value = "name", required = true) String name,
                      @JsonProperty(value = "product", required = true) String product,
                      @JsonProperty(value = "default_location", required = true) DefaultLocation defaultLocation) {
}
