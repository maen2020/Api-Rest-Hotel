package com.maen.hotel.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    @Column(name = "birthdate")
    private Date birthDate;
    @Enumerated(value = EnumType.STRING)
    private UserGender gender;
    @Column(name = "creationdate")
    private LocalDate creationDate;
}
