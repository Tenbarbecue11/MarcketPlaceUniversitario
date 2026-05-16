package com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PurchaseRequestDTO {

    @NotNull(message = "El id del post es obligatorio")
    private Long postId;

    @NotNull(message = "El id del comprador es obligatorio")
    private Long buyerId;

    @NotNull(message = "El id del vendedor es obligatorio")
    private Long sellerId;

    private String estado;
}