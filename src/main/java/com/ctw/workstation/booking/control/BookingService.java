package com.ctw.workstation.booking.control;

import com.ctw.workstation.booking.entity.Booking;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class BookingService {
    public List<Booking> getAll() {
        return Booking.listAll();
    }

    public Booking getById(UUID id) {
        return Booking.findById(id);
    }

    public Booking create(Booking item) {
        Booking.persist(item);
        return item;
    }

    public Booking modify(UUID id, Booking item) {
        Booking old = Booking.findById(id);
        if (old == null) {
            return null;
        }
        Booking.persist(item);
        return item;
    }

    public Booking remove(UUID id) {
        Booking toDel = Booking.findById(id);
        if (toDel == null) {
            return null;
        }

        Booking.deleteById(id);
        return toDel;
    }
}
