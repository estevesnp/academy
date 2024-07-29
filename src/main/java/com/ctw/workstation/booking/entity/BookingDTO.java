package com.ctw.workstation.booking.entity;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record BookingDTO(UUID getId,
                         @NotNull LocalDateTime getBookFrom,
                         @NotNull LocalDateTime getBookTo,
                         @NotNull UUID getRackId,
                         @NotNull UUID getRequesterId) {
}
