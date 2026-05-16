package com.example.MarcketPlaceUniversitario.controller;

import com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales.NotificationRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales.NotificationResponseDTO;
import com.example.MarcketPlaceUniversitario.service.NotificationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Notification")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public NotificationResponseDTO guardar(@Valid @RequestBody NotificationRequestDTO dto) {
        return notificationService.guardar(dto);
    }

    @GetMapping
    public List<NotificationResponseDTO> obtenerTodos() {
        return notificationService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public NotificationResponseDTO obtener(@PathVariable long id) {
        return notificationService.findById(id);
    }

    @PutMapping("/{id}")
    public NotificationResponseDTO actualizar(@PathVariable long id, @Valid @RequestBody NotificationRequestDTO dto) {
        return notificationService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable long id) {
        notificationService.deleteById(id);
    }
}