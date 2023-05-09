package com.maen.hotel.service;

import com.maen.hotel.mapper.UserInDTOToUser;
import com.maen.hotel.persistence.entity.UserEntity;
import com.maen.hotel.persistence.repository.IUserRepository;
import com.maen.hotel.service.dto.UserInDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    private final UserInDTOToUser mapper;

    public List<UserEntity> getAllUser(){
        return this.userRepository.findAll();
    }

    public UserEntity saveUser(UserInDTO userInDTO){
        UserEntity userEntity = mapper.map(userInDTO);
        return this.userRepository.save(userEntity);
    }

    public UserEntity updateUser(Integer id, UserEntity userEntity){
        UserEntity user = userRepository.findById(id).get();
        user.setName(userEntity.getName());
        user.setEmail(userEntity.getEmail());
        user.setBirthDate(userEntity.getBirthDate());
        user.setGender(userEntity.getGender());
        userRepository.save(user);
        return user;
    }

    public void deleteUsers(Integer id){
        this.userRepository.deleteById(id);
    }
}
