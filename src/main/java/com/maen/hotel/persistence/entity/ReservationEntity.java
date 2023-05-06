package com.maen.hotel.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "reservations")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bagscount")
    private Integer bagsCount;

    @Column(name = "arrivaldate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date arrivalDate;

    @Column(name = "departuredate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date departureDate;

    @Column(name = "roomnumber")
    private Integer roomNumber;

    private Double price;

    private Integer userId;
}
