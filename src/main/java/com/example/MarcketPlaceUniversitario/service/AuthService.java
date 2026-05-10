package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.DTO.DtoExtra.LoginRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.DtoExtra.LoginResponseDTO;
import com.example.MarcketPlaceUniversitario.DTO.DtoExtra.RegisterRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales.UsuarioResponseDTO;

public interface AuthService {
    UsuarioResponseDTO register(RegisterRequestDTO dto);
    LoginResponseDTO login(LoginRequestDTO dto);
}
