package com.maen.hotel.persistence.repository;

import com.maen.hotel.persistence.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservationRepository extends JpaRepository<ReservationEntity, Integer> {
}
