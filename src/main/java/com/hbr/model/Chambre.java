// src/main/java/com/hbr/model/Chambre.java
package com.hbr.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private String categorie;
    private String typeLit;
    private Double superficie;
    private Double prix;
    private String[] images;
    private String statut; // LIBRE, OCCUPEE, RESERVEE, LOUEE

    private String horairesEntree;
    private String horairesSortie;
}
