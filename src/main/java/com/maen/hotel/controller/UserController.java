package com.maen.hotel.controller;

import com.maen.hotel.exceptions.GlobalNotFoundException;
import com.maen.hotel.persistence.entity.UserEntity;
import com.maen.hotel.service.UserService;
import com.maen.hotel.service.dto.UserInDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers() throws GlobalNotFoundException {
        return this.userService.getAllUser();
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> getById(@PathVariable Integer id) throws GlobalNotFoundException{
        return this.userService.getByIdUser(id);
    }

    @PostMapping
    public ResponseEntity<UserEntity> saveUser(@Valid @RequestBody UserInDTO userInDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.saveUser(userInDTO));
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Integer id, @RequestBody UserEntity userEntity) throws GlobalNotFoundException{
        return this.userService.updateUser(id, userEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) throws GlobalNotFoundException{
        this.userService.deleteUsers(id);
    }
}