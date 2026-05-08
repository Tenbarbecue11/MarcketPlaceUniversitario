package com.example.MarcketPlaceUniversitario.controller;

import com.example.MarcketPlaceUniversitario.DTO.LoginRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.LoginResponseDTO;
import com.example.MarcketPlaceUniversitario.DTO.RegisterRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.UsuarioResponseDTO;
import com.example.MarcketPlaceUniversitario.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping ("/register")
    public UsuarioResponseDTO register(@Valid @RequestBody RegisterRequestDTO dto) {
        return authService.register(dto);
    }

    @PostMapping ("login")
    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO dto) {
        return authService.login(dto);
    }

}
