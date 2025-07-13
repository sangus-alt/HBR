// src/main/java/com/hbr/model/Produit.java
package com.hbr.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;
    private String photo;
    private Double prixAchat;
    private Double prixVente;

    @ManyToOne
    private Categorie categorie;

    @ManyToOne
    private Magasin magasin;
}
