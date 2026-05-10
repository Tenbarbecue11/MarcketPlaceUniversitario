// ===============================
// DTO - VerifyCodeRequestDTO
// ===============================

package com.example.MarcketPlaceUniversitario.DTO.DtoExtra;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VerifyCodeRequestDTO {

    @NotBlank
    private String correo;

    @NotBlank
    private String codigo;
}