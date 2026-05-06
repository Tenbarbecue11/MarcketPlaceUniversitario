package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.model.Notification;

import java.util.List;

public interface NotificationService {
    Notification guardar(Notification notification);
    List<Notification> obtenerTodos();
    Notification findById(long id);
    Notification update(Notification notification,long id);
    void deleteById(long id);

}
