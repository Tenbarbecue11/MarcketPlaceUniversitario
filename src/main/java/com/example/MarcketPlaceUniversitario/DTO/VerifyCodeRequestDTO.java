// ===============================
// DTO - VerifyCodeRequestDTO
// ===============================

package com.example.MarcketPlaceUniversitario.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VerifyCodeRequestDTO {

    @NotBlank
    private String correo;

    @NotBlank
    private String codigo;
}