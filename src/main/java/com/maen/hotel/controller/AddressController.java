package com.maen.hotel.controller;

import com.maen.hotel.persistence.entity.AddressEntity;
import com.maen.hotel.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/addresses")
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public List<AddressEntity> getAllAddresses(){
        return this.addressService.getAllAddress();
    }

    @PostMapping
    public AddressEntity saveAddress(@RequestBody AddressEntity addressEntity){
        return this.addressService.saveAddrees(addressEntity);
    }

    @PutMapping("/{id}")
    public AddressEntity updateAddress(@PathVariable Integer id, @RequestBody AddressEntity addressEntity){
        return this.addressService.updateAddress(id, addressEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Integer id){
        this.addressService.deleteAddress(id);
    }
}