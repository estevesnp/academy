package com.ctw.workstation.rackasset.boundary;

import com.ctw.workstation.rackasset.control.RackAssetService;
import com.ctw.workstation.rackasset.entity.RackAsset;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;

import java.util.List;
import java.util.UUID;

@Transactional
@Path("/workstation/rackassets")
public class RackAssetResource {

    @Inject
    RackAssetService service;

    @GET
    public List<RackAsset> getRackAssets() {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    public RackAsset getById(@PathParam("id") UUID id) {
        RackAsset RackAsset = service.getById(id);

        if (RackAsset == null) {
            throw new NotFoundException();
        }

        return RackAsset;
    }

    @POST
    public RackAsset postRackAsset(RackAsset RackAsset) {
        return service.create(RackAsset);
    }

    @PUT
    @Path("/{id}")
    public RackAsset updateRackAsset(@PathParam("id") UUID id, RackAsset RackAsset) {
        RackAsset updated = service.modify(id, RackAsset);

        if (updated == null) {
            throw new NotFoundException();
        }

        return updated;
    }

    @DELETE
    @Path("/{id}")
    public RackAsset deleteRackAsset(@PathParam("id") UUID id) {
        RackAsset deleted = service.remove(id);

        if (deleted == null) {
            throw new NotFoundException();
        }

        return deleted;
    }
}
