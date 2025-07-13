// src/main/java/com/hbr/model/Salle.java
package com.hbr.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String type; // REUNION, CONFERENCE
    private String statut; // LIBRE, OCCUPEE, RESERVEE, FERMEE
}
