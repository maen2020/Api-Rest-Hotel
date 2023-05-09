package com.maen.hotel.service.dto;

import com.maen.hotel.persistence.entity.UserGender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserInDTO {

    @NotBlank(message = "Name is required.")
    private String name;

    @NotBlank(message = "Email is required.")
    @Email(message = "The email address is invalid.")
    private String email;

    @NotNull(message = "Birth date is required.")
    private Date birthDate;

    @NotNull(message = "Gender is required.")
    private UserGender gender;
}
