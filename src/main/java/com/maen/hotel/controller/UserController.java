package com.maen.hotel.controller;

import com.maen.hotel.persistence.entity.UserEntity;
import com.maen.hotel.service.UserService;
import com.maen.hotel.service.dto.UserInDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers(){
        return this.userService.getAllUser();
    }

    @PostMapping
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserInDTO userInDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.saveUser(userInDTO));
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Integer id, @RequestBody UserEntity userEntity){
        return this.userService.updateUser(id, userEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        this.userService.deleteUsers(id);
    }
}