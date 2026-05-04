package com.example.MarcketPlaceUniversitario.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue
    private Long id;
    @Column (nullable = false)
    private String message;
    @Column (nullable = false)
    private Boolean leido;
    @Column (nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sender_id")
    @JsonBackReference("message-sender")
    private Usuario sender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "receiver_id")
    @JsonBackReference
    private Usuario receiver;

}
