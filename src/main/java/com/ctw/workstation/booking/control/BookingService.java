package com.ctw.workstation.booking.control;

import com.ctw.workstation.booking.boundary.BookingRepository;
import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.exceptions.EntityNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class BookingService {

    @Inject
    BookingRepository repo;

    public List<Booking> getAll() {
        return repo.listAll();
    }

    public Booking getById(UUID id) throws EntityNotFoundException {
        Booking booking = repo.findById(id);
        if (booking == null) {
            throw new EntityNotFoundException("Booking not found");
        }
        return booking;
    }

    public Booking create(Booking item) {
        repo.persist(item);
        return item;
    }

    public Booking modify(UUID id, Booking item) throws EntityNotFoundException {
        Booking booking = repo.findById(id);
        if (booking == null) {
            throw new EntityNotFoundException("Booking not found");
        }
        booking.setBookFrom(item.getBookFrom());
        booking.setBookTo(item.getBookTo());
        booking.setRackId(item.getRackId());
        booking.setRequesterId(item.getRequesterId());
        return booking;
    }

    public void remove(UUID id) throws EntityNotFoundException {
        if (!repo.deleteById(id)) {
            throw new EntityNotFoundException("Booking not found");
        }
    }
}
