package com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostImagenResponseDTO {

    private Long id;
    private String url;
    private int orden;
}