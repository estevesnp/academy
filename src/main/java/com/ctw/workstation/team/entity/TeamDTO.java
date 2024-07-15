package com.ctw.workstation.team.entity;

import com.ctw.workstation.entity.DefaultLocation;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record TeamDTO(@JsonProperty("id") UUID getId,
                      @JsonProperty(value = "name", required = true) String getName,
                      @JsonProperty(value = "product", required = true) String getProduct,
                      @JsonProperty(value = "default_location", required = true) DefaultLocation getDefaultLocation) {
}
