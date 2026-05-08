package com.example.MarcketPlaceUniversitario.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {
    private Long id;
    private String nombre;
    private String correo;
    private String rol;
    private boolean estado;
}
