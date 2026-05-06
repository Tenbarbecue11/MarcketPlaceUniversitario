package com.example.MarcketPlaceUniversitario.repository;

import com.example.MarcketPlaceUniversitario.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    //Optional<Message> findByMessage(String message);
    //Optional<Message> findByDate(LocalDateTime date);
}
