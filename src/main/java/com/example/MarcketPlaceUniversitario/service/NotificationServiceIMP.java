package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.model.Notification;
import com.example.MarcketPlaceUniversitario.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceIMP implements NotificationService {
    private final NotificationRepository notificationRepository;
    public NotificationServiceIMP(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }
    @Override
    public Notification guardar(Notification notification) {
        return  notificationRepository.save(notification);
    }

    @Override
    public List<Notification> obtenerTodos() {
        return  notificationRepository.findAll();
    }

    @Override
    public Notification findById(long id) {
        return  notificationRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Notification no encontrado"));
    }

    @Override
    public Notification update(Notification notification, long id) {
        Notification existente=findById(id);
        existente.setTitulo(notification.getTitulo());
        existente.setTipo(notification.getTipo());
        existente.setMensaje(notification.getMensaje());
        return notificationRepository.save(existente);
    }

    @Override
    public void deleteById(long id) {
        findById(id);
        notificationRepository.deleteById(id);
    }
}
