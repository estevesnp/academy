package com.ctw.workstation.booking.entity;

import com.ctw.workstation.domain.AbstractModel;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "t_booking")
public class Booking extends AbstractModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private UUID id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "book_from", nullable = false)
    private LocalDateTime bookFrom;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "book_to", nullable = false)
    private LocalDateTime bookTo;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at", nullable = true)
    private LocalDateTime modifiedAt;
    private UUID rackId;
    private UUID requesterId;

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

    public LocalDateTime getBookFrom() {
        return bookFrom;
    }

    public void setBookFrom(LocalDateTime bookFrom) {
        this.bookFrom = bookFrom;
    }

    public LocalDateTime getBookTo() {
        return bookTo;
    }

    public void setBookTo(LocalDateTime bookTo) {
        this.bookTo = bookTo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
