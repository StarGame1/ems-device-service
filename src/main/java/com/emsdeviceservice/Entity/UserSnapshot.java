package com.emsdeviceservice.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users_snapshot")
public class UserSnapshot {

    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private String role;

    public UserSnapshot() {}

    public UserSnapshot(Long id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
