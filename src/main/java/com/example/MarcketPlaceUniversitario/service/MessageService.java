package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales.MessageRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales.MessageResponseDTO;

import java.util.List;

public interface MessageService {
    MessageResponseDTO guardar(MessageRequestDTO dto);
    List<MessageResponseDTO> obtenerTodos();
    MessageResponseDTO buscarPorId(long id);
    MessageResponseDTO actualizar(MessageRequestDTO dto, long id);
    void eliminar(long id);
}