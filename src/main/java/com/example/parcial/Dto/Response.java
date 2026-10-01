package com.example.parcial.Dto;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.parcial.Entity.User;

public class Response {

    //1
    public static class UserResponse {
        private Long id;
        private String username;
        private String email;

        public UserResponse() {
        }

        public UserResponse(Long id, String username, String email) {
            this.id = id;
            this.username = username;
            this.email = email;
        }

        public UserResponse(User user) {
            this(user.getId(), user.getUsername(), user.getEmail());
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }

    //2
    public static class PagedResponseDto<T> {
        private List<T> content;
        private int page;
        private int size;
        private long totalElements;

        public PagedResponseDto(Page<T> pageResult) {
            this.content = pageResult.getContent();
            this.page = pageResult.getNumber();
            this.size = pageResult.getSize();
            this.totalElements = pageResult.getTotalElements();
        }

        public List<T> getContent() { return content; }
        public int getPage() { return page; }
        public int getSize() { return size; }
        public long getTotalElements() { return totalElements; }
    }
}
