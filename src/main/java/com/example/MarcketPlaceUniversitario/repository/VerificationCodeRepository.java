// ===============================
// REPOSITORY
// ===============================

package com.example.MarcketPlaceUniversitario.repository;

import com.example.MarcketPlaceUniversitario.model.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerificationCodeRepository
        extends JpaRepository<VerificationCode, Long> {

    Optional<VerificationCode>
    findByCorreoAndCodigo(String correo, String codigo);
}