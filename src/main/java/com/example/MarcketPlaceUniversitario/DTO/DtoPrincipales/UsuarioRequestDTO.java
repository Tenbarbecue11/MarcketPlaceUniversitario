package com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales;


import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UsuarioRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El correo es obligatorio")
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@ucundinamarca\\.edu\\.co$",
            message = "Debe usar un correo institucional"
    )
    private String correo;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener mínimo 8 caracteres")
    private String password;
}