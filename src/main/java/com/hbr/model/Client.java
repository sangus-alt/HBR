// src/main/java/com/hbr/model/Client.java
package com.hbr.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenoms;
    private String sexe;
    private LocalDate dateNaissance;
    private String telephone;
    private String email;
    private String photo;
    private String profession;
    private String domicile;
}
