package com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioResponseDTO {

    private Long id;

    private String nombre;

    private String correo;

    private String rol;

    private Boolean estado;
}