package com.example.MarcketPlaceUniversitario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ratings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int Puntuacion;

    @Column(nullable = false)
    private String Comentario;

    @Column(nullable = false)
    private String Tipo;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "from_id")
    private Usuario from;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "to_id")
    private Usuario to;


}
