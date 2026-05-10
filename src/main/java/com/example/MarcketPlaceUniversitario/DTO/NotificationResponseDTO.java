package com.example.MarcketPlaceUniversitario.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationResponseDTO {

    private Long id;
    private String titulo;
    private String mensaje;
    private String tipo;
    private Boolean leido;
    private LocalDateTime fecha;
    private Long usuarioId;
    private String usuarioNombre;
}