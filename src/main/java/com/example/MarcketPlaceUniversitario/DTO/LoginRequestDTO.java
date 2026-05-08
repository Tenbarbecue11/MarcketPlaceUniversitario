package com.example.MarcketPlaceUniversitario.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDTO {

    @NotBlank
    @Email
    private String correo;

    @NotBlank
    private String password;
}
