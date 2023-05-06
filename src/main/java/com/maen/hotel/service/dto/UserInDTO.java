package com.maen.hotel.service.dto;

import com.maen.hotel.persistence.entity.UserGender;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserInDTO {

    private String name;
    private String email;
    private Date birthDate;
    private UserGender gender;
}
