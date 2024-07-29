package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.entity.Booking;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class BookingRepository implements PanacheRepositoryBase<Booking, UUID> {
}
