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
@Table(name = "campus_event")
public class CampusEvent {

    public enum Category {
        ACADEMIC,
        CULTURAL,
        SPORT,
        TECHNOLOGY
    }

    public enum Status {
        DRAFT,
        PUBLISHED,
        CANCELLED,
        FINISHED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long organizerId;

    @Column(nullable = false)
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private ZonedDateTime eventDate;

    @Column(nullable = false)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.DRAFT;

    public CampusEvent() {
    }

    public CampusEvent(Long organizerId, String title, String description, Category category,
                       ZonedDateTime eventDate, String location) {
        this.organizerId = organizerId;
        this.title = title;
        this.description = description;
        this.category = category;
        this.eventDate = eventDate;
        this.location = location;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getOrganizerId() { return organizerId; }
    public void setOrganizerId(Long organizerId) { this.organizerId = organizerId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public ZonedDateTime getEventDate() { return eventDate; }
    public void setEventDate(ZonedDateTime eventDate) { this.eventDate = eventDate; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
