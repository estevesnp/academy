package com.ctw.workstation.booking.entity;

import com.ctw.workstation.domain.AbstractModel;

import java.time.LocalDate;
import java.util.UUID;

public class Booking extends AbstractModel {
    private UUID rackId;
    private UUID requesterId;
    private LocalDate bookFrom;
    private LocalDate bookTo;
    private LocalDate createdAt;
    private LocalDate modifiedAt;

    public UUID getRackId() {
        return rackId;
    }

    public UUID getRequesterId() {
        return requesterId;
    }

    public LocalDate getBookFrom() {
        return bookFrom;
    }

    public LocalDate getBookTo() {
        return bookTo;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getModifiedAt() {
        return modifiedAt;
    }

    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }

    public void setRequesterId(UUID requesterId) {
        this.requesterId = requesterId;
    }

    public void setBookFrom(LocalDate bookFrom) {
        this.bookFrom = bookFrom;
    }

    public void setBookTo(LocalDate bookTo) {
        this.bookTo = bookTo;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(LocalDate modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}