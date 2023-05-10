package com.maen.hotel.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "addresses")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Country is required.")
    private String country;

    @NotBlank(message = "City is required.")
    private String city;

    @Column(name = "zip_code")
    @NotBlank(message = "Zip code is required.")
    private String zipCode;

    @NotBlank(message = "Street is required.")
    private String street;

    @NotBlank(message = "State is required.")
    private String state;

    @Column(name = "user_id")
    @NotNull(message = "Id is required.")
    private Integer userId;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity userEntities;
}
