package com.maen.hotel.controller;

import com.maen.hotel.exceptions.GlobalNotFoundException;
import com.maen.hotel.persistence.entity.ReservationEntity;
import com.maen.hotel.service.ReservationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping
    public List<ReservationEntity> getAllReservations(){
        return this.reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Optional<ReservationEntity> getByIdReservation(@PathVariable Integer id) throws GlobalNotFoundException {
        return this.reservationService.getByIdReservation(id);
    }

    @PostMapping
    public ReservationEntity saveReservation(@Valid @RequestBody ReservationEntity reservationEntity){
        return this.reservationService.saveReservation(reservationEntity);
    }

    @PutMapping("/{id}")
    public ReservationEntity updateReservation(@PathVariable Integer id, @RequestBody ReservationEntity reservationEntity) throws GlobalNotFoundException {
        return this.reservationService.updateReservation(id,reservationEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Integer id) throws GlobalNotFoundException{
        this.reservationService.deleteReservation(id);
    }
}
