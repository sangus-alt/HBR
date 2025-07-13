// src/main/java/com/hbr/model/LigneFacture.java
package com.hbr.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LigneFacture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantite;
    private Double prixUnitaire;
    private Double total;

    @ManyToOne
    private Produit produit;

    @ManyToOne
    private Facture facture;
}
