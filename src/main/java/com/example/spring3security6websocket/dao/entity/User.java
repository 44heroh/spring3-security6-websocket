package com.example.spring3security6websocket.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", schema = "messages")
public class User extends BaseEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
    joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
    schema = "messages"
    )
    private List<Role> roles;

    public User(String name, String email, String password, List<Role> roles) {
        this.username = email;
        this.firstName = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.setCreated(new Date());
        this.setUpdated(new Date());
        this.setStatus(Status.ACTIVE);
    }
}
