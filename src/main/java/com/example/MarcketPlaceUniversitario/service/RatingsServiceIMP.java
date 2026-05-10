package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.DTO.RatingRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.RatingResponseDTO;
import com.example.MarcketPlaceUniversitario.model.Ratings;
import com.example.MarcketPlaceUniversitario.model.Usuario;
import com.example.MarcketPlaceUniversitario.repository.RatingsRepository;
import com.example.MarcketPlaceUniversitario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingsServiceIMP implements RatingsService {

    private final RatingsRepository ratingsRepository;
    private final UsuarioRepository usuarioRepository;

    public RatingsServiceIMP(RatingsRepository ratingsRepository, UsuarioRepository usuarioRepository) {
        this.ratingsRepository = ratingsRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public RatingResponseDTO save(RatingRequestDTO dto) {
        Usuario from = usuarioRepository.findById(dto.getFromId())
                .orElseThrow(() -> new RuntimeException("Usuario 'from' no encontrado"));
        Usuario to = usuarioRepository.findById(dto.getToId())
                .orElseThrow(() -> new RuntimeException("Usuario 'to' no encontrado"));

        Ratings rating = new Ratings();
        rating.setPuntuacion(dto.getPuntuacion());
        rating.setComentario(dto.getComentario());
        rating.setTipo(dto.getTipo());
        rating.setDate(LocalDate.now());
        rating.setFrom(from);
        rating.setTo(to);

        return toDTO(ratingsRepository.save(rating));
    }

    @Override
    public RatingResponseDTO findById(long id) {
        return toDTO(ratingsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calificación no encontrada")));
    }

    @Override
    public RatingResponseDTO update(RatingRequestDTO dto, long id) {
        Ratings existente = ratingsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calificación no encontrada"));
        existente.setComentario(dto.getComentario());
        existente.setPuntuacion(dto.getPuntuacion());
        existente.setTipo(dto.getTipo());
        return toDTO(ratingsRepository.save(existente));
    }

    @Override
    public void delete(long id) {
        ratingsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calificación no encontrada"));
        ratingsRepository.deleteById(id);
    }

    @Override
    public List<RatingResponseDTO> listar() {
        return ratingsRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    private RatingResponseDTO toDTO(Ratings r) {
        return new RatingResponseDTO(
                r.getId(), r.getPuntuacion(), r.getComentario(), r.getTipo(), r.getDate(),
                r.getFrom() != null ? r.getFrom().getId() : null,
                r.getFrom() != null ? r.getFrom().getNombre() : null,
                r.getTo() != null ? r.getTo().getId() : null,
                r.getTo() != null ? r.getTo().getNombre() : null
        );
    }
}