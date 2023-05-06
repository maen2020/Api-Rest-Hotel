package com.maen.hotel.service;

import com.maen.hotel.persistence.entity.AddressEntity;
import com.maen.hotel.persistence.repository.IAddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {

    private final IAddressRepository addressRepository;

    public List<AddressEntity> getAllAddress(){
        return this.addressRepository.findAll();
    }

    public AddressEntity saveAddrees(AddressEntity addressEntity){
        return this.addressRepository.save(addressEntity);
    }

    public AddressEntity updateAddress(Integer id, AddressEntity addressEntity){
        AddressEntity address = addressRepository.findById(id).get();
        address.setCountry(addressEntity.getCountry());
        address.setCity(addressEntity.getCity());
        address.setZipCode(addressEntity.getZipCode());
        address.setStreet(addressEntity.getStreet());
        address.setState(addressEntity.getState());
        addressRepository.save(address);
        return address;
    }

    public void deleteAddress(Integer id){
        this.addressRepository.deleteById(id);
    }
}
