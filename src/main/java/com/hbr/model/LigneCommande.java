// src/main/java/com/hbr/model/LigneCommande.java
package com.hbr.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LigneCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantite;
    private Double prixUnitaire;
    private Double total;

    @ManyToOne
    private Produit produit;

    @ManyToOne
    private Commande commande;
}
