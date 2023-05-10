package com.maen.hotel.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "reservations")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bags_count")
    @NotNull(message = "Bags count is required.")
    private Integer bagsCount;

    @Column(name = "arrival_date")
    @NotNull(message = "Arrival date is required.")
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date arrivalDate;

    @Column(name = "departure_date")
    @NotNull(message = "Departure date date is required.")
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date departureDate;

    @Column(name = "room_number")
    @NotNull(message = "Room number is required.")
    private Integer roomNumber;

    @NotNull(message = "Price is required.")
    private Double price;

    @Column(name = "user_id")
    @NotNull(message = "Id is required.")
    private Integer userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity userEntities;
}
