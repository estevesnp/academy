package com.ctw.workstation.rackasset.boundary;

import com.ctw.workstation.exceptions.EntityNotFoundException;
import com.ctw.workstation.rackasset.control.RackAssetService;
import com.ctw.workstation.rackasset.entity.RackAsset;
import com.ctw.workstation.rackasset.entity.RackAssetDTO;
import com.ctw.workstation.rackasset.entity.RackAssetMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
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
        try {
            RackAsset rackAsset = service.getById(id);
            return Response.status(200)
                    .entity(RackAssetMapper.domainToDTO(rackAsset))
                    .build();

        } catch (EntityNotFoundException e) {
            return Response.status(404, e.getMessage()).build();
        }
    }

    @POST
    public Response postRackAsset(RackAssetDTO assetDTO) {
        RackAsset asset = service.create(RackAssetMapper.dtoToDomain(assetDTO));
        return Response.status(201)
                .entity(RackAssetMapper.domainToDTO(asset))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateRackAsset(@PathParam("id") UUID id, RackAssetDTO assetDTO) {
        try {
            RackAsset updated = service.modify(id, RackAssetMapper.dtoToDomain(assetDTO));
            return Response.status(201)
                    .entity(RackAssetMapper.domainToDTO(updated))
                    .build();

        } catch (EntityNotFoundException e) {
            return Response.status(404, e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRackAsset(@PathParam("id") UUID id) {
        try {
            service.remove(id);
            return Response.status(200).build();
        } catch (EntityNotFoundException e) {
            return Response.status(410, e.getMessage()).build();
        }
    }
}
