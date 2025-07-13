// src/main/java/com/hbr/model/Facture.java
package com.hbr.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private LocalDateTime dateEmission;
    private String typeDocument; // PDF, Ticket, etc.
    private String pointDeVente;
    private Double montantTotal;
    private Double montantPaye;
    private Double resteAPayer;
    private String statut; // PAYEE, NON_PAYEE

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL)
    private List<LigneFacture> lignes;
}
