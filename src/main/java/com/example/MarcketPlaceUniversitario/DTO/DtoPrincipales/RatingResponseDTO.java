package com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingResponseDTO {

    private Long id;
    private int puntuacion;
    private String comentario;
    private String tipo;
    private LocalDate date;
    private Long fromId;
    private String fromNombre;
    private Long toId;
    private String toNombre;
}