package com.example.parcial.Dto;

import java.time.ZonedDateTime;

import com.example.parcial.Entity.CampusEvent;

public class Request {
    //1
    public static class RegisterRequest {
        private String username;
        private String email;
        private String password;

        public RegisterRequest() {
        }

        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
    //2
    public static class EventRequest {
        private String title;
        private String description;
        private CampusEvent.Category category;
        private ZonedDateTime eventDate;
        private String location;

        public EventRequest() {
        }

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

        public CampusEvent.Category getCategory() { return category; }
        public void setCategory(CampusEvent.Category category) { this.category = category; }

        public ZonedDateTime getEventDate() { return eventDate; }
        public void setEventDate(ZonedDateTime eventDate) { this.eventDate = eventDate; }

        public String getLocation() { return location; }
        public void setLocation(String location) { this.location = location; }
    }
    //3
    // "tickedtyoeID":3

    // Login
    public static class LoginRequest {
        private String email;
        private String password;

        public LoginRequest() {
        }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}
