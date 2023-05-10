package com.maen.hotel.service;

import com.maen.hotel.exceptions.GlobalNotFoundException;
import com.maen.hotel.persistence.entity.AddressEntity;
import com.maen.hotel.persistence.repository.IAddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressService {

    private final IAddressRepository addressRepository;

    public List<AddressEntity> getAllAddress(){
        return this.addressRepository.findAll();
    }

    public Optional<AddressEntity> getByIdAddress(Integer id) throws GlobalNotFoundException {
        Optional<AddressEntity> address = addressRepository.findById(id);
        if (!address.isPresent()){
            throw new GlobalNotFoundException("Resource not found.");
        }
        return this.addressRepository.findById(id);
    }

    public AddressEntity saveAddrees(AddressEntity addressEntity){
        return this.addressRepository.save(addressEntity);
    }

    public AddressEntity updateAddress(Integer id, AddressEntity addressEntity) throws GlobalNotFoundException{
        Optional<AddressEntity> update = addressRepository.findById(id);
        if (!update.isPresent()){
            throw new GlobalNotFoundException("Update failed, resource not found.");
        }
        AddressEntity address = addressRepository.findById(id).get();
        address.setCountry(addressEntity.getCountry());
        address.setCity(addressEntity.getCity());
        address.setZipCode(addressEntity.getZipCode());
        address.setStreet(addressEntity.getStreet());
        address.setState(addressEntity.getState());
        addressRepository.save(address);
        return address;
    }

    public void deleteAddress(Integer id) throws GlobalNotFoundException{
        Optional<AddressEntity> delete = addressRepository.findById(id);
        if (!delete.isPresent()){
            throw new GlobalNotFoundException("Error when trying to delete a non-existing resource.");
        }
        this.addressRepository.deleteById(id);
    }
}
