package com.ctw.workstation.rackasset.boundary;

import com.ctw.workstation.rackasset.control.RackAssetService;
import com.ctw.workstation.rackasset.entity.RackAsset;
import com.ctw.workstation.rackasset.entity.RackAssetDTO;
import com.ctw.workstation.rackasset.entity.RackAssetMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Transactional
@Path("/workstation/rackassets")
public class RackAssetResource {

    @Inject
    RackAssetService service;

    @GET
    public List<RackAssetDTO> getRackAssets() {
        return service.getAll().stream()
                .map(RackAssetMapper::domainToDTO)
                .toList();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") UUID id) {
        RackAsset rackAsset = service.getById(id);
        return Response.status(200)
                .entity(RackAssetMapper.domainToDTO(rackAsset))
                .build();

    }

    @POST
    public Response postRackAsset(@Valid RackAssetDTO assetDTO) {
        RackAsset asset = service.create(RackAssetMapper.dtoToDomain(assetDTO));
        return Response.status(201)
                .entity(RackAssetMapper.domainToDTO(asset))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateRackAsset(@PathParam("id") UUID id, @Valid RackAssetDTO assetDTO) {
        RackAsset updated = service.modify(id, RackAssetMapper.dtoToDomain(assetDTO));
        return Response.status(201)
                .entity(RackAssetMapper.domainToDTO(updated))
                .build();

    }

    @DELETE
    @Path("/{id}")
    public Response deleteRackAsset(@PathParam("id") UUID id) {
        service.remove(id);
        return Response.status(200).build();
    }
}
