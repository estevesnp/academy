package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.booking.service.BookingService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;

import java.util.List;
import java.util.UUID;

@Transactional
@Path("/workstation/bookings")
public class BookingResource {

    @Inject
    BookingService service;

    @GET
    public List<Booking> getBookings() {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    public Booking getById(@PathParam("id") UUID id) {
        Booking booking = service.getById(id);
        if (booking == null) {
            throw new NotFoundException();
        }
        return service.getById(id);
    }

    @POST
    public Booking postBooking(Booking booking) {
        return service.create(booking);
    }

    @PUT
    @Path("/{id}")
    public Booking updateBooking(@PathParam("id") UUID id, Booking booking) {
        Booking updated = service.modify(id, booking);
        if (updated == null) {
            throw new NotFoundException();
        }
        return updated;
    }

    @DELETE
    @Path("/{id}")
    public Booking deleteBooking(@PathParam("id") UUID id) {
        Booking deleted = service.remove(id);
        if (deleted == null) {
            throw new NotFoundException();
        }
        return deleted;
    }
}
