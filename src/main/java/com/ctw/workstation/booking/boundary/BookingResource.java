package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.domain.Repository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;

import java.util.List;
import java.util.UUID;

@Transactional
@Path("/workstation/bookings")
public class BookingResource {

    @Inject
    private Repository<Booking> repo;

    @GET
    public List<Booking> getBookings() {
        return repo.getAll();
    }

    @GET
    @Path("/{id}")
    public Booking getById(@PathParam("id") UUID id) {
        Booking booking = repo.getById(id);

        if (booking == null) {
            throw new NotFoundException();
        }

        return repo.getById(id);
    }

    @POST
    public Booking postBooking(Booking booking) {
        return repo.create(booking);
    }

    @PUT
    @Path("/{id}")
    public Booking updateBooking(@PathParam("id") UUID id, Booking booking) {
        Booking updated = repo.modify(id, booking);

        if (updated == null) {
            throw new NotFoundException();
        }

        return updated;
    }

    @DELETE
    @Path("/{id}")
    public Booking deleteBooking(@PathParam("id") UUID id) {
        Booking deleted = repo.remove(id);

        if (deleted == null) {
            throw new NotFoundException();
        }

        return deleted;
    }
}
