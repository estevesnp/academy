package com.ctw.workstation.rack.boundary;

import com.ctw.workstation.domainentity.RackStatus;
import com.ctw.workstation.rack.control.RackService;
import com.ctw.workstation.rack.entity.Rack;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;

import java.util.List;
import java.util.UUID;

@Transactional
@Path("/workstation/racks")
public class RackResource {

    @Inject
    RackService service;

    @GET
    public List<Rack> getRacks(@QueryParam("status") RackStatus status) {
        if (status == null) {
            return service.getAll();
        }

        return service.getAll().stream()
                .filter(rack -> rack.getStatus() == status)
                .toList();
    }

    @GET
    @Path("/{id}")
    public Rack getById(@PathParam("id") UUID id) {
        Rack rack = service.getById(id);

        if (rack == null) {
            throw new NotFoundException();
        }

        return rack;
    }

    @POST
    public Rack postRack(Rack rack) {
        return service.create(rack);
    }

    @PUT
    @Path("/{id}")
    public Rack updateRack(@PathParam("id") UUID id, Rack rack) {
        Rack updated = service.modify(id, rack);
        if (updated == null) {
            throw new NotFoundException();
        }

        return updated;
    }

    @DELETE
    @Path("/{id}")
    public Rack deleteRack(@PathParam("id") UUID id) {
        Rack deleted = service.remove(id);

        if (deleted == null) {
            throw new NotFoundException();
        }

        return deleted;
    }

}
