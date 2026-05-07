package com.example.MarcketPlaceUniversitario.service;

import com.example.MarcketPlaceUniversitario.model.Message;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;

public interface MessageService {
    Message guardar(Message message);
    List<Message> obtenerTodos();
    Message buscarPorId(long id);
    Message actualizar(Message message,long id);
    void eliminar(long id);
    //Message findByMessage(String message);
    //Message findByDate(LocalDateTime date);

}
