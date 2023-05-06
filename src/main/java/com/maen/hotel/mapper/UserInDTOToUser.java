package com.maen.hotel.mapper;

import com.maen.hotel.persistence.entity.UserEntity;
import com.maen.hotel.service.dto.UserInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserInDTOToUser implements IUserMapper<UserInDTO, UserEntity> {
    @Override
    public UserEntity map(UserInDTO in) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(in.getName());
        userEntity.setEmail(in.getEmail());
        userEntity.setBirthDate(in.getBirthDate());
        userEntity.setGender(in.getGender());

        userEntity.setCreationDate(LocalDate.now());
        return userEntity;
    }
}
