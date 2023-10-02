package com.example.mainapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String email;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
    @Column(name = "is_expired")
    private Boolean isExpired;
    @Column(name = "registration_date")
    private LocalDateTime registrationDate;
}
