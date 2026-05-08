package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.DTO.RegisterRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.UsuarioResponseDTO;

public interface AuthService {
    UsuarioResponseDTO register(RegisterRequestDTO dto);
}
