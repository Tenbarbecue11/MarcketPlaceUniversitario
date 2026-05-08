package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.DTO.LoginRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.LoginResponseDTO;
import com.example.MarcketPlaceUniversitario.DTO.RegisterRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.UsuarioResponseDTO;

public interface AuthService {
    UsuarioResponseDTO register(RegisterRequestDTO dto);
    LoginResponseDTO login(LoginRequestDTO dto);
}
