package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales.PurchaseRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales.PurchaseResponseDTO;

import java.util.List;

public interface PurchaseRequestService {
    PurchaseResponseDTO findById(long id);
    PurchaseResponseDTO save(PurchaseRequestDTO dto);
    PurchaseResponseDTO update(PurchaseRequestDTO dto, long id);
    void delete(long id);
    List<PurchaseResponseDTO> findAllPurchaseRequests();
}