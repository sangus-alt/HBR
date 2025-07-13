// src/main/java/com/hbr/model/Conge.java
package com.hbr.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate debut;
    private LocalDate fin;
    private String motif;

    @ManyToOne
    private Employe employe;
}
