package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.DTO.RatingRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.RatingResponseDTO;

import java.util.List;

public interface RatingsService {
    RatingResponseDTO findById(long id);
    RatingResponseDTO save(RatingRequestDTO dto);
    RatingResponseDTO update(RatingRequestDTO dto, long id);
    void delete(long id);
    List<RatingResponseDTO> listar();
}