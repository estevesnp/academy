package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.control.BookingService;
import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.booking.entity.BookingDTO;
import com.ctw.workstation.booking.entity.BookingMapper;
import com.ctw.workstation.exceptions.EntityNotFoundException;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Transactional
@Path("/workstation/bookings")
public class BookingResource {

    @Inject
    BookingService service;

    @GET
    public List<BookingDTO> getBookings() {
        return service.getAll().stream()
                .map(BookingMapper::domainToDTO)
                .toList();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") UUID id) {
        try {
            Booking booking = service.getById(id);
            return Response.status(200)
                    .entity(BookingMapper.domainToDTO(booking))
                    .build();

        } catch (EntityNotFoundException e) {
            return Response.status(404, e.getMessage()).build();
        }
    }

    @POST
    public Response postBooking(BookingDTO bookingDTO) {
        Booking booking = service.create(BookingMapper.dtoToDomain(bookingDTO));
        return Response.status(201)
                .entity(BookingMapper.domainToDTO(booking))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateBooking(@PathParam("id") UUID id, BookingDTO bookingDTO) {
        try {
            Booking updated = service.modify(id, BookingMapper.dtoToDomain(bookingDTO));
            return Response.status(201)
                    .entity(BookingMapper.domainToDTO(updated))
                    .build();

        } catch (EntityNotFoundException e) {
            return Response.status(404, e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBooking(@PathParam("id") UUID id) {
        try {
            service.remove(id);
            return Response.status(200).build();
        } catch (EntityNotFoundException e) {
            return Response.status(404, e.getMessage()).build();
        }
    }
}
