package com.maen.hotel.persistence.entity;

import jakarta.persistence.*;
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
    private String country;
    private String city;
    @Column(name = "zipcode")
    private String zipCode;
    private String street;
    private String state;
    @Column(name = "userid")
    private Integer userId;
}
