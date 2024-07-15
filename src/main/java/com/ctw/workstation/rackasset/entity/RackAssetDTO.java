package com.ctw.workstation.rackasset.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record RackAssetDTO(@JsonProperty("id") UUID getId,
                           @JsonProperty(value = "asset_tag", required = true) String getAssetTag,
                           @JsonProperty(value = "rack_id", required = true) UUID getRackId) {
}
