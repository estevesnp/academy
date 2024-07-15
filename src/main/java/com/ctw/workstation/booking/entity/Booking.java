package com.ctw.workstation.booking.entity;

import com.ctw.workstation.entity.AbstractTimedEntity;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.teammember.entity.TeamMember;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "t_booking")
public class Booking extends AbstractTimedEntity {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "book_from", nullable = false)
    private LocalDateTime bookFrom;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "book_to", nullable = false)
    private LocalDateTime bookTo;
    @Column(name = "rack_id", nullable = false)
    private UUID rackId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rack_id", updatable = false, insertable = false, nullable = false)
    private Rack rack;
    @Column(name = "requester_id", nullable = false)
    private UUID requesterId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requester_id", updatable = false, insertable = false, nullable = false)
    private TeamMember requester;

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

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public TeamMember getRequester() {
        return requester;
    }

    public void setRequester(TeamMember requester) {
        this.requester = requester;
    }
}
