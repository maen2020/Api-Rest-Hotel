package com.maen.hotel.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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

    @Column(name = "birth_date")
    private Date birthDate;

    @Enumerated(value = EnumType.STRING)
    private UserGender gender;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "userEntities", cascade = CascadeType.ALL)
    @JsonManagedReference
    private AddressEntity address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userEntities", cascade = CascadeType.ALL)
    private List<ReservationEntity> reservations;
}
