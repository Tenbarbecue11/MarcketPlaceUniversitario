// ===============================
// SERVICE
// ===============================

package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.DTO.SendCodeRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.VerifyCodeRequestDTO;

public interface VerificationCodeService {

    String sendCode(SendCodeRequestDTO dto);

    String verifyCode(VerifyCodeRequestDTO dto);
}