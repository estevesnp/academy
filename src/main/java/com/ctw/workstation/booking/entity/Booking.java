package com.ctw.workstation.booking.entity;

import com.ctw.workstation.domain.AbstractModel;

import java.time.LocalDate;
import java.util.UUID;

public class Booking extends AbstractModel {
    private UUID id;
    private UUID rackId;
    private UUID requesterId;
    private LocalDate bookFrom;
    private LocalDate bookTo;
    private LocalDate createdAt;
    private LocalDate modifiedAt;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getRackId() {
        return rackId;
    }

    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }

    public UUID getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(UUID requesterId) {
        this.requesterId = requesterId;
    }

    public LocalDate getBookFrom() {
        return bookFrom;
    }

    public void setBookFrom(LocalDate bookFrom) {
        this.bookFrom = bookFrom;
    }

    public LocalDate getBookTo() {
        return bookTo;
    }

    public void setBookTo(LocalDate bookTo) {
        this.bookTo = bookTo;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDate modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
