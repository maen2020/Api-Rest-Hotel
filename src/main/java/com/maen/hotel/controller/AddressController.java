package com.maen.hotel.controller;

import com.maen.hotel.exceptions.GlobalNotFoundException;
import com.maen.hotel.persistence.entity.AddressEntity;
import com.maen.hotel.persistence.entity.UserEntity;
import com.maen.hotel.service.AddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/addresses")
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public List<AddressEntity> getAllAddresses(){
        return this.addressService.getAllAddress();
    }

    @GetMapping("/{id}")
    public Optional<AddressEntity> getByIdAddress(@PathVariable Integer id) throws GlobalNotFoundException {
        return this.addressService.getByIdAddress(id);
    }

    @PostMapping
    public AddressEntity saveAddress(@Valid @RequestBody AddressEntity addressEntity){
        return this.addressService.saveAddrees(addressEntity);
    }

    @PutMapping("/{id}")
    public AddressEntity updateAddress(@PathVariable Integer id, @RequestBody AddressEntity addressEntity) throws GlobalNotFoundException{
        return this.addressService.updateAddress(id, addressEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Integer id) throws GlobalNotFoundException{
        this.addressService.deleteAddress(id);
    }
}