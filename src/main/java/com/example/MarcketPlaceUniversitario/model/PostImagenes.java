package com.example.MarcketPlaceUniversitario.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostImagenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String url;
    @Column
    private int orden;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "IdPost",nullable = false)
    @JsonBackReference("Post-Imagen")
    private Posts posts;

}
