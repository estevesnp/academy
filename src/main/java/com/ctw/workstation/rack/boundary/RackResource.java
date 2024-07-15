package com.ctw.workstation.rack.boundary;

import com.ctw.workstation.exceptions.EntityNotFoundException;
import com.ctw.workstation.rack.control.RackService;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.entity.RackDTO;
import com.ctw.workstation.rack.entity.RackMapper;
import com.ctw.workstation.rack.entity.RackStatus;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Transactional
@Path("/workstation/racks")
public class RackResource {

    @Inject
    RackService service;

    @GET
    public List<RackDTO> getRacks(@QueryParam("status") RackStatus status) {
        if (status == null) {
            return service.getAll().stream()
                    .map(RackMapper::domainToDTO)
                    .toList();
        }

        return service.getAll().stream()
                .filter(rack -> rack.getStatus() == status)
                .map(RackMapper::domainToDTO)
                .toList();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") UUID id) {
        try {
            Rack rack = service.getById(id);
            return Response.status(200)
                    .entity(RackMapper.domainToDTO(rack))
                    .build();

        } catch (EntityNotFoundException e) {
            return Response.status(404, e.getMessage()).build();
        }
    }

    @POST
    public Response postRack(RackDTO rackDTO) {
        Rack rack = service.create(RackMapper.dtoToDomain(rackDTO));
        return Response.status(201)
                .entity(RackMapper.domainToDTO(rack))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateRack(@PathParam("id") UUID id, RackDTO rackDTO) {
        try {
            Rack rack = service.modify(id, RackMapper.dtoToDomain(rackDTO));
            return Response.status(201)
                    .entity(RackMapper.domainToDTO(rack))
                    .build();

        } catch (EntityNotFoundException e) {
            return Response.status(404, e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRack(@PathParam("id") UUID id) {
        try {
            service.remove(id);
            return Response.status(200).build();
        } catch (EntityNotFoundException e) {
            return Response.status(410, e.getMessage()).build();
        }
    }

}
