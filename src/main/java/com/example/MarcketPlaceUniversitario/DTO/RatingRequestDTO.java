package com.example.MarcketPlaceUniversitario.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RatingRequestDTO {

    @Min(value = 1, message = "La puntuación mínima es 1")
    @Max(value = 5, message = "La puntuación máxima es 5")
    private int puntuacion;

    @NotBlank(message = "El comentario es obligatorio")
    private String comentario;

    @NotBlank(message = "El tipo es obligatorio")
    private String tipo;

    @NotNull(message = "El id del usuario que califica es obligatorio")
    private Long fromId;

    @NotNull(message = "El id del usuario calificado es obligatorio")
    private Long toId;
}