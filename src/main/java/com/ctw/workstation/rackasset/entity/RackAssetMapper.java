package com.ctw.workstation.rackasset.entity;

public class RackAssetMapper {
    public static RackAsset dtoToDomain(RackAssetDTO dto) {
        RackAsset asset = new RackAsset();

        asset.setId(dto.getId());
        asset.setAssetTag(dto.getAssetTag());
        asset.setRackId(dto.getId());

        return asset;
    }

    public static RackAssetDTO domainToDTO(RackAsset asset) {
        return new RackAssetDTO(asset.getId(), asset.getAssetTag(), asset.getRackId());
    }
}
