package com.example.MarcketPlaceUniversitario.controller;

import com.example.MarcketPlaceUniversitario.model.Notification;
import com.example.MarcketPlaceUniversitario.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/Notification")
public class NotificationController {

    private final NotificationService notificationService;
    public NotificationController(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    @PostMapping
    public Notification guardar(@RequestBody Notification notification) {
        return notificationService.guardar(notification);
    }
    @GetMapping
    public List<Notification> obtenerTodos(){
        return notificationService.obtenerTodos();
    }
    @GetMapping("/{id}")
    public Notification obtener(@PathVariable long id){
        return notificationService.findById(id);
    }
    @PutMapping ("/{id}")
    public Notification actualizar(@PathVariable long id, @RequestBody Notification notification){
        return notificationService.update(notification, id);
    }
    @DeleteMapping ("/{id}")
    public void eliminar(@PathVariable long id){
        notificationService.deleteById(id);
    }
}
