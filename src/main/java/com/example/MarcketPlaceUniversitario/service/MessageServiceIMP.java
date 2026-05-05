package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.model.Message;
import com.example.MarcketPlaceUniversitario.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceIMP implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceIMP(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @Override
    public Message guardar(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> obtenerTodos() {
        return messageRepository.findAll();
    }

    @Override
    public Message buscarPorId(long id) {
        return messageRepository.findById(id).
                orElseThrow(()-> new RuntimeException("message no encontrado"));
    }

    @Override
    public Message actualizar(Message message,long id) {
        Message existente=buscarPorId(id);
        existente.setMessage(message.getMessage());
        existente.setId(message.getId());
        existente.setSender(message.getSender());
        existente.setReceiver(message.getReceiver());
        return messageRepository.save(existente);
    }

    @Override
    public void eliminar(long id) {
        buscarPorId(id);
        messageRepository.deleteById(id);

    }

    @Override
    public Message findBymessage(String message) {
        return messageRepository.findBymessage(message).orElseThrow(
                ()-> new RuntimeException("message no encontrado"));
    }

    @Override
    public Message findByDate(LocalDateTime date) {
        return messageRepository.findByDate(date).orElseThrow(
                ()-> new RuntimeException("message no encontrado"));
    }
}
