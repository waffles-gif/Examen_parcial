package com.example.parcial.Entity;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "events_registration")
public class EventsRegistration {

    public enum Status {
        CONFIRMED,
        CHECKED_IN,
        CANCELLED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long eventId;

    @Column(nullable = false)
    private Long ticketTypeId;

    @Column(nullable = false)
    private Long attendeeId;

    @Column(nullable = false)
    private ZonedDateTime registeredAt = ZonedDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.CONFIRMED;

    public EventsRegistration() {
    }

    public EventsRegistration(Long eventId, Long ticketTypeId, Long attendeeId) {
        this.eventId = eventId;
        this.ticketTypeId = ticketTypeId;
        this.attendeeId = attendeeId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

    public Long getTicketTypeId() { return ticketTypeId; }
    public void setTicketTypeId(Long ticketTypeId) { this.ticketTypeId = ticketTypeId; }

    public Long getAttendeeId() { return attendeeId; }
    public void setAttendeeId(Long attendeeId) { this.attendeeId = attendeeId; }

    public ZonedDateTime getRegisteredAt() { return registeredAt; }
    public void setRegisteredAt(ZonedDateTime registeredAt) { this.registeredAt = registeredAt; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
