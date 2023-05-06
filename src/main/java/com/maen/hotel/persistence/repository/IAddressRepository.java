package com.maen.hotel.persistence.repository;

import com.maen.hotel.persistence.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<AddressEntity, Integer> {
}
