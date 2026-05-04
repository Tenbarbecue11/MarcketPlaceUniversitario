package com.example.MarcketPlaceUniversitario.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id", nullable = false)
    @JsonBackReference("Purchase-Post")
    private Posts post;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seller_id")
    @JsonBackReference("Purchase_seller")
    private Usuario seller;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "buyer_id")
    @JsonBackReference
    private Usuario buyer;
}
