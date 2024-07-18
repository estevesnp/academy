package com.ctw.workstation.rackasset.entity;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RackAssetMapperTest {

    @Test
    void rackAssetDtoToDomain() {
        UUID id = UUID.randomUUID();
        String assetTag = "asset tag";
        UUID rackId = UUID.randomUUID();

        RackAssetDTO dto = new RackAssetDTO(id, assetTag, rackId);


        RackAsset rackAsset = RackAssetMapper.dtoToDomain(dto);


        assertEquals(id, rackAsset.getId(), "Verifying id is properly set");
        assertEquals(assetTag, rackAsset.getAssetTag(), "Verifying assetTag is properly set");
        assertEquals(rackId, rackAsset.getRackId(), "Verifying rackId is properly set");
    }

    @Test
    void rackAssetDomainToDTO() {
        UUID id = UUID.randomUUID();
        String assetTag = "asset tag";
        UUID rackId = UUID.randomUUID();

        RackAsset rackAsset = new RackAsset();
        rackAsset.setId(id);
        rackAsset.setAssetTag(assetTag);
        rackAsset.setRackId(rackId);


        RackAssetDTO dto = RackAssetMapper.domainToDTO(rackAsset);


        assertEquals(id, dto.getId(), "Verifying id is properly set");
        assertEquals(assetTag, dto.getAssetTag(), "Verifying assetTag is properly set");
        assertEquals(rackId, dto.getRackId(), "Verifying rackId is properly set");
    }
}