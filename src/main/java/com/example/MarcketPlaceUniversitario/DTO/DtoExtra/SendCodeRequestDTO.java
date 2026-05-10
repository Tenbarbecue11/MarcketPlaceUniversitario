// ===============================
// DTO - SendCodeRequestDTO
// ===============================

package com.example.MarcketPlaceUniversitario.DTO.DtoExtra;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SendCodeRequestDTO {

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Correo inválido")
    private String correo;
}