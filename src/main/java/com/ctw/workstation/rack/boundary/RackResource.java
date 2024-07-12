package com.ctw.workstation.rack.boundary;

import com.ctw.workstation.domain.RackStatus;
import com.ctw.workstation.domain.Repository;
import com.ctw.workstation.rack.entity.Rack;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;
import java.util.UUID;

@Path("/workstation/racks")
public class RackResource {

    @Inject
    Repository<Rack> repo;

    @GET
    public List<Rack> getRacks(@QueryParam("status") RackStatus status) {
        if (status == null) {
            return repo.getAll();
        }

        return repo.getAll().stream()
                .filter(rack -> rack.getStatus() == status)
                .toList();
    }

    @GET
    @Path("/{id}")
    public Rack getById(@PathParam("id") UUID id) {
        Rack rack = repo.getById(id);

        if (rack == null) {
            throw new NotFoundException();
        }

        return rack;
    }

    @POST
    public Rack postRack(Rack rack) {
        return repo.create(rack);
    }

    @PUT
    @Path("/{id}")
    public Rack updateRack(@PathParam("id") UUID id, Rack rack) {
        Rack updated = repo.modify(id, rack);
        if (updated == null) {
            throw new NotFoundException();
        }

        return updated;
    }

    @DELETE
    @Path("/{id}")
    public Rack deleteRack(@PathParam("id") UUID id) {
        Rack deleted = repo.remove(id);

        if (deleted == null) {
            throw new NotFoundException();
        }

        return deleted;
    }

}