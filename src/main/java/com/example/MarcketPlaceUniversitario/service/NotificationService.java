package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales.NotificationRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales.NotificationResponseDTO;

import java.util.List;

public interface NotificationService {
    NotificationResponseDTO guardar(NotificationRequestDTO dto);
    List<NotificationResponseDTO> obtenerTodos();
    NotificationResponseDTO findById(long id);
    NotificationResponseDTO update(NotificationRequestDTO dto, long id);
    void deleteById(long id);
}