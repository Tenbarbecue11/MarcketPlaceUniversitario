package com.example.MarcketPlaceUniversitario.controller;

import com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales.RatingRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales.RatingResponseDTO;
import com.example.MarcketPlaceUniversitario.service.RatingsService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Ratings")
public class RatingsController {

    private final RatingsService ratingsService;

    public RatingsController(RatingsService ratingsService) {
        this.ratingsService = ratingsService;
    }

    @PostMapping
    public RatingResponseDTO save(@Valid @RequestBody RatingRequestDTO dto) {
        return ratingsService.save(dto);
    }

    @GetMapping
    public List<RatingResponseDTO> findAll() {
        return ratingsService.listar();
    }

    @GetMapping("/{id}")
    public RatingResponseDTO findById(@PathVariable long id) {
        return ratingsService.findById(id);
    }

    @PutMapping("/{id}")
    public RatingResponseDTO update(@PathVariable long id, @Valid @RequestBody RatingRequestDTO dto) {
        return ratingsService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        ratingsService.delete(id);
    }
}