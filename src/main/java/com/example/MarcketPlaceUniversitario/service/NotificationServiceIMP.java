package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales.NotificationRequestDTO;
import com.example.MarcketPlaceUniversitario.DTO.DtoPrincipales.NotificationResponseDTO;
import com.example.MarcketPlaceUniversitario.model.Notification;
import com.example.MarcketPlaceUniversitario.model.Usuario;
import com.example.MarcketPlaceUniversitario.repository.NotificationRepository;
import com.example.MarcketPlaceUniversitario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceIMP implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final UsuarioRepository usuarioRepository;

    public NotificationServiceIMP(NotificationRepository notificationRepository, UsuarioRepository usuarioRepository) {
        this.notificationRepository = notificationRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public NotificationResponseDTO guardar(NotificationRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Notification n = new Notification();
        n.setTitulo(dto.getTitulo());
        n.setMensaje(dto.getMensaje());
        n.setTipo(dto.getTipo());
        n.setLeido(false);
        n.setFecha(LocalDateTime.now());
        n.setUsuario(usuario);

        return toDTO(notificationRepository.save(n));
    }

    @Override
    public List<NotificationResponseDTO> obtenerTodos() {
        return notificationRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public NotificationResponseDTO findById(long id) {
        return toDTO(notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificación no encontrada")));
    }

    @Override
    public NotificationResponseDTO update(NotificationRequestDTO dto, long id) {
        Notification existente = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificación no encontrada"));
        existente.setTitulo(dto.getTitulo());
        existente.setMensaje(dto.getMensaje());
        existente.setTipo(dto.getTipo());
        return toDTO(notificationRepository.save(existente));
    }

    @Override
    public void deleteById(long id) {
        notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificación no encontrada"));
        notificationRepository.deleteById(id);
    }

    private NotificationResponseDTO toDTO(Notification n) {
        return new NotificationResponseDTO(
                n.getId(), n.getTitulo(), n.getMensaje(), n.getTipo(), n.getLeido(), n.getFecha(),
                n.getUsuario() != null ? n.getUsuario().getId() : null,
                n.getUsuario() != null ? n.getUsuario().getNombre() : null
        );
    }
}