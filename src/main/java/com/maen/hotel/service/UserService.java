package com.maen.hotel.service;

import com.maen.hotel.exceptions.GlobalNotFoundException;
import com.maen.hotel.mapper.UserInDTOToUser;
import com.maen.hotel.persistence.entity.UserEntity;
import com.maen.hotel.persistence.repository.IUserRepository;
import com.maen.hotel.service.dto.UserInDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    private final UserInDTOToUser mapper;

    public List<UserEntity> getAllUser(){
        return this.userRepository.findAll();
    }

    public Optional<UserEntity> getByIdUser(Integer id) throws GlobalNotFoundException{
        Optional<UserEntity> user = userRepository.findById(id);
        if (!user.isPresent()){
            throw new GlobalNotFoundException("Resource not found.");
        }
        return userRepository.findById(id);
    }

    public UserEntity saveUser(UserInDTO userInDTO){
        UserEntity userEntity = mapper.map(userInDTO);
        return this.userRepository.save(userEntity);
    }

    public UserEntity updateUser(Integer id, UserEntity userEntity) throws GlobalNotFoundException{
        Optional<UserEntity> updateUser = userRepository.findById(id);
        if (!updateUser.isPresent()){
            throw new GlobalNotFoundException("Update failed, resource not found.");
        }
        UserEntity user = userRepository.findById(id).get();
        user.setName(userEntity.getName());
        user.setEmail(userEntity.getEmail());
        user.setBirthDate(userEntity.getBirthDate());
        user.setGender(userEntity.getGender());
        userRepository.save(user);
        return user;
    }

    public void deleteUsers(Integer id) throws GlobalNotFoundException{
        Optional<UserEntity> deleteUser = userRepository.findById(id);
        if (!deleteUser.isPresent()){
            throw new GlobalNotFoundException("Error when trying to delete a non-existing resource.");
        }
        this.userRepository.deleteById(id);
    }
}
