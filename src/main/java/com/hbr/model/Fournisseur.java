// src/main/java/com/hbr/model/Fournisseur.java
package com.hbr.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;
    private String telephone;
    private String adresse;
    private String logo;
    private String type; // entreprise ou particulier
    private String motDePasse; // s’il a un compte

    private Boolean compteActive;
}
