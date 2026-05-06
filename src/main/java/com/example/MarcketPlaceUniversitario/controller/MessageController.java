package com.example.MarcketPlaceUniversitario.controller;

import com.example.MarcketPlaceUniversitario.model.Message;
import com.example.MarcketPlaceUniversitario.service.MessageService;
import org.springframework.web.bind.annotation.*;

//import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/Mensaje")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @PostMapping
    public Message guardarMessage(@RequestBody Message message) {
        return messageService.guardar(message);
    }

    @GetMapping ("/{id}")
    public Message buscarPorId(@PathVariable long id) {
        return messageService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Message actualizar(@RequestBody Message message,@PathVariable long id) {
        return messageService.actualizar(message,id);
    }

    @GetMapping
    public List<Message> buscarTodos() {
        return messageService.obtenerTodos();
    }

    @DeleteMapping ("/{id}")
    public void eliminar(@PathVariable long id) {
        messageService.eliminar(id);
    }
}
