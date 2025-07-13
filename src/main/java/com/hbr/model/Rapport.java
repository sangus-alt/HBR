// src/main/java/com/hbr/model/Rapport.java
package com.hbr.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rapport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // Ventes, Paiements, Réservations, etc.
    private String format; // PDF, Excel
    private String contenu;
}
