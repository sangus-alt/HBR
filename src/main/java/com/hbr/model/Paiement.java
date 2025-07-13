// src/main/java/com/hbr/model/Paiement.java
package com.hbr.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime datePaiement;
    private String modePaiement; // espèces, carte, mobile money, etc.
    private Double montant;

    @ManyToOne
    private Facture facture;
}
