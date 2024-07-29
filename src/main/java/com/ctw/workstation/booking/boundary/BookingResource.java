package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.control.BookingService;
import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.booking.entity.BookingDTO;
import com.ctw.workstation.booking.entity.BookingMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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
        Booking booking = service.getById(id);
        return Response.status(200)
                .entity(BookingMapper.domainToDTO(booking))
                .build();
    }

    @POST
    public Response postBooking(@Valid BookingDTO bookingDTO) {
        Booking booking = service.create(BookingMapper.dtoToDomain(bookingDTO));
        return Response.status(201)
                .entity(BookingMapper.domainToDTO(booking))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateBooking(@PathParam("id") UUID id, @Valid BookingDTO bookingDTO) {
        Booking updated = service.modify(id, BookingMapper.dtoToDomain(bookingDTO));
        return Response.status(201)
                .entity(BookingMapper.domainToDTO(updated))
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBooking(@PathParam("id") UUID id) {
        service.remove(id);
        return Response.status(200).build();
    }
}
