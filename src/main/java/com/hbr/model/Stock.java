// src/main/java/com/hbr/model/Stock.java
package com.hbr.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantite;
    private String codeBarre;
    private String qrCode;
    private String provenance;
    private String fabricant;

    @OneToOne
    private Produit produit;

    @ManyToOne
    private Magasin magasin;
}
