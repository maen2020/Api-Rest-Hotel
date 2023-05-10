package com.maen.hotel.service;

import com.maen.hotel.exceptions.GlobalNotFoundException;
import com.maen.hotel.persistence.entity.ReservationEntity;
import com.maen.hotel.persistence.repository.IReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@RequestMapping("/api/v1/reservations")
public class ReservationService {

    private final IReservationRepository reservationRepository;

    public List<ReservationEntity> getAllReservations() {
        return this.reservationRepository.findAll();
    }

    public Optional<ReservationEntity> getByIdReservation(Integer id) throws GlobalNotFoundException {
        Optional<ReservationEntity> reservation = reservationRepository.findById(id);
        if (!reservation.isPresent()) {
            throw new GlobalNotFoundException("Resource not found.");
        }
        return reservationRepository.findById(id);
    }

    public ReservationEntity saveReservation(ReservationEntity reservationEntity){
        return this.reservationRepository.save(reservationEntity);
    }

    public ReservationEntity updateReservation(Integer id, ReservationEntity reservationEntity) throws GlobalNotFoundException{
        Optional<ReservationEntity> updateReservation = reservationRepository.findById(id);
        if (!updateReservation.isPresent()){
            throw new GlobalNotFoundException("Update failed, resource not found.");
        }
        ReservationEntity reservation = reservationRepository.findById(id).get();
        reservation.setBagsCount(reservationEntity.getBagsCount());
        reservation.setArrivalDate(reservationEntity.getArrivalDate());
        reservation.setDepartureDate(reservationEntity.getDepartureDate());
        reservation.setRoomNumber(reservationEntity.getRoomNumber());
        reservation.setPrice(reservationEntity.getPrice());
        reservationRepository.save(reservation);
        return reservation;
    }

    public void deleteReservation(Integer id) throws GlobalNotFoundException{
        Optional<ReservationEntity> deleteReservation = reservationRepository.findById(id);
        if (!deleteReservation.isPresent()){
            throw new GlobalNotFoundException("Error when trying to delete a non-existing resource.");
        }
        this.reservationRepository.deleteById(id);
    }
}
