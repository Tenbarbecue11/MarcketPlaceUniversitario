package com.example.MarcketPlaceUniversitario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String mensaje;
    @Column (nullable = false)
    private String tipo; //mensage, compra, sistema
    @Column (nullable = false)
    private Boolean leido;
    @Column (nullable = false)
    private LocalDateTime fecha;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "Usuario_id")
    private Usuario usuario;
}
