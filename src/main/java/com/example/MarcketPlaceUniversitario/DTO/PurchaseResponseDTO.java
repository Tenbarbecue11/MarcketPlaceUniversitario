package com.example.MarcketPlaceUniversitario.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseResponseDTO {

    private Long id;
    private String estado;
    private LocalDate fecha;
    private Long postId;
    private String postTitulo;
    private Long buyerId;
    private String buyerNombre;
    private Long sellerId;
    private String sellerNombre;
}