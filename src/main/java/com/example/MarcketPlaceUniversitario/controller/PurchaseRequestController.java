package com.example.MarcketPlaceUniversitario.controller;

import com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales.PurchaseRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales.PurchaseResponseDTO;
import com.example.MarcketPlaceUniversitario.service.PurchaseRequestService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Request")
public class PurchaseRequestController {

    private final PurchaseRequestService purchaseRequestService;

    public PurchaseRequestController(PurchaseRequestService purchaseRequestService) {
        this.purchaseRequestService = purchaseRequestService;
    }

    @PostMapping
    public PurchaseResponseDTO save(@Valid @RequestBody PurchaseRequestDTO dto) {
        return purchaseRequestService.save(dto);
    }

    @GetMapping
    public List<PurchaseResponseDTO> findAll() {
        return purchaseRequestService.findAllPurchaseRequests();
    }

    @GetMapping("/{id}")
    public PurchaseResponseDTO findById(@PathVariable long id) {
        return purchaseRequestService.findById(id);
    }

    @PutMapping("/{id}")
    public PurchaseResponseDTO update(@PathVariable long id, @Valid @RequestBody PurchaseRequestDTO dto) {
        return purchaseRequestService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        purchaseRequestService.delete(id);
    }
}