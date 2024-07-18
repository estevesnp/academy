package com.ctw.workstation.booking.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookingMapperTest {

    @Test
    void bookingDtoToDomain() {
        UUID id = UUID.randomUUID();
        LocalDateTime bookFrom = LocalDateTime.now();
        LocalDateTime bookTo = LocalDateTime.now();
        UUID rackId = UUID.randomUUID();
        UUID requesterId = UUID.randomUUID();

        BookingDTO dto = new BookingDTO(id, bookFrom, bookTo, rackId, requesterId);


        Booking booking = BookingMapper.dtoToDomain(dto);


        assertEquals(id, booking.getId(), "Verifying id is properly set");
        assertEquals(bookFrom, booking.getBookFrom(), "Verifying bookFrom is properly set");
        assertEquals(bookTo, booking.getBookTo(), "Verifying bookTo is properly set");
        assertEquals(rackId, booking.getRackId(), "Verifying rackId is properly set");
        assertEquals(requesterId, booking.getRequesterId(), "Verifying requesterId is properly set");
    }

    @Test
    void bookingDomainToDTO() {
        UUID id = UUID.randomUUID();
        LocalDateTime bookFrom = LocalDateTime.now();
        LocalDateTime bookTo = LocalDateTime.now();
        UUID rackId = UUID.randomUUID();
        UUID requesterId = UUID.randomUUID();

        Booking booking = new Booking();
        booking.setId(id);
        booking.setBookFrom(bookFrom);
        booking.setBookTo(bookTo);
        booking.setRackId(rackId);
        booking.setRequesterId(requesterId);


        BookingDTO dto = BookingMapper.domainToDTO(booking);

        assertEquals(id, dto.getId(), "Verifying id is properly set");
        assertEquals(bookFrom, dto.getBookFrom(), "Verifying bookFrom is properly set");
        assertEquals(bookTo, dto.getBookTo(), "Verifying bookTo is properly set");
        assertEquals(rackId, dto.getRackId(), "Verifying rackId is properly set");
        assertEquals(requesterId, dto.getRequesterId(), "Verifying requesterId is properly set");
    }
}