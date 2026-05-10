// ===============================
// CONTROLLER
// ===============================

package com.example.MarcketPlaceUniversitario.controller;

import com.example.MarcketPlaceUniversitario.DTO.DtoExtra.SendCodeRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.DtoExtra.VerifyCodeRequestDTO;
import com.example.MarcketPlaceUniversitario.service.VerificationCodeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verification")
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;

    // enviar código
    @PostMapping("/send-code")
    public String sendCode(
            @Valid
            @RequestBody
            SendCodeRequestDTO dto){

        return verificationCodeService
                .sendCode(dto);
    }

    // verificar código
    @PostMapping("/verify-code")
    public String verifyCode(
            @Valid
            @RequestBody
            VerifyCodeRequestDTO dto){

        return verificationCodeService
                .verifyCode(dto);
    }
}