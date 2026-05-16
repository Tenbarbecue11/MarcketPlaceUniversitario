package com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MessageRequestDTO {

    @NotBlank(message = "El mensaje no puede estar vacío")
    private String message;

    @NotNull(message = "El id del remitente es obligatorio")
    private Long senderId;

    @NotNull(message = "El id del destinatario es obligatorio")
    private Long receiverId;
}