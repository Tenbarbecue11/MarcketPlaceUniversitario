package com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponseDTO {

    private Long id;
    private String message;
    private Boolean leido;
    private LocalDateTime dateTime;
    private Long senderId;
    private String senderNombre;
    private Long receiverId;
    private String receiverNombre;
}