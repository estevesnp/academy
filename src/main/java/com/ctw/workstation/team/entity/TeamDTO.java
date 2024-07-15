package com.ctw.workstation.team.entity;

import com.ctw.workstation.entity.DefaultLocation;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record TeamDTO(@JsonProperty("id") UUID getId, @JsonProperty("name") String getName,
                      @JsonProperty("product") String getProduct,
                      @JsonProperty("default_location") DefaultLocation getDefaultLocation) {
}
