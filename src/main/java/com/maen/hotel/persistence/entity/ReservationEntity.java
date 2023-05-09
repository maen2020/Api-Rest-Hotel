package com.maen.hotel.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Bags count is required.")
    private Integer bagsCount;

    @Column(name = "arrivaldate")
    @NotNull(message = "Arrival date is required.")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date arrivalDate;

    @Column(name = "departuredate")
    @NotNull(message = "Departure date date is required.")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date departureDate;

    @Column(name = "roomnumber")
    @NotNull(message = "Room number is required.")
    private Integer roomNumber;

    @NotNull(message = "Price is required.")
    private Double price;

    private Integer userId;
}
