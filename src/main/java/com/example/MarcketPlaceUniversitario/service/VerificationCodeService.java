// ===============================
// SERVICE
// ===============================

package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.DTO.DtoExtra.SendCodeRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.DtoExtra.VerifyCodeRequestDTO;

public interface VerificationCodeService {

    String sendCode(SendCodeRequestDTO dto);

    String verifyCode(VerifyCodeRequestDTO dto);
}