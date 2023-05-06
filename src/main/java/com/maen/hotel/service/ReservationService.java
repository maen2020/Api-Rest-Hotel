package com.maen.hotel.service;

import com.maen.hotel.persistence.entity.ReservationEntity;
import com.maen.hotel.persistence.repository.IReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@AllArgsConstructor
@RequestMapping("/api/v1/reservations")
public class ReservationService {

    private final IReservationRepository reservationRepository;

    public List<ReservationEntity> getAllReservations() {
        return this.reservationRepository.findAll();
    }

    public ReservationEntity saveReservation(ReservationEntity reservationEntity){
        return this.reservationRepository.save(reservationEntity);
    }

    public ReservationEntity updateReservation(Integer id, ReservationEntity reservationEntity){
        ReservationEntity reservation = reservationRepository.findById(id).get();
        reservation.setBagsCount(reservationEntity.getBagsCount());
        reservation.setArrivalDate(reservationEntity.getArrivalDate());
        reservation.setDepartureDate(reservationEntity.getDepartureDate());
        reservation.setRoomNumber(reservationEntity.getRoomNumber());
        reservation.setPrice(reservationEntity.getPrice());
        reservationRepository.save(reservation);
        return reservation;
    }

    public void deleteReservation(Integer id){
        this.reservationRepository.deleteById(id);
    }
}
