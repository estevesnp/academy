package com.ctw.workstation.rackasset.entity;

import java.util.UUID;

public record RackAssetDTO(UUID getId, String getAssetTag, UUID getRackedId) {
}
