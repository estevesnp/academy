package com.ctw.workstation.booking.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public record BookingDTO(@JsonProperty("id") UUID getId,
                         @JsonProperty(value = "book_from", required = true) LocalDateTime getBookFrom,
                         @JsonProperty(value = "book_to", required = true) LocalDateTime getBookTo,
                         @JsonProperty(value = "rack_id", required = true) UUID getRackId,
                         @JsonProperty(value = "requester_id", required = true) UUID getRequesterId) {
}
