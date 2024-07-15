package com.ctw.workstation.booking.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public record BookingDTO(UUID getId, LocalDateTime getCreatedAt,
                         LocalDateTime getModifiedAt, LocalDateTime getBookFrom,
                         LocalDateTime getBookTo, UUID getRackId, UUID getRequesterId) {
}
