package com.ctw.workstation.booking.control;

import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.exceptions.EntityNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class BookingService {
    public List<Booking> getAll() {
        return Booking.listAll();
    }

    public Booking getById(UUID id) throws EntityNotFoundException {
        Booking booking = Booking.findById(id);
        if (booking == null) {
            throw new EntityNotFoundException("Booking not found");
        }
        return booking;
    }

    public Booking create(Booking item) {
        Booking.persist(item);
        return item;
    }

    public Booking modify(UUID id, Booking item) throws EntityNotFoundException {
        if (Booking.findById(id) == null) {
            throw new EntityNotFoundException("Booking not found");
        }
        Booking.persist(item);
        return item;
    }

    public void remove(UUID id) throws EntityNotFoundException {
        if (!Booking.deleteById(id)) {
            throw new EntityNotFoundException("Booking not found");
        }
    }
}
