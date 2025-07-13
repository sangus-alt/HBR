// src/main/java/com/hbr/model/Reservation.java
package com.hbr.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // HOTEL, RESTAURANT, BAR
    private LocalDateTime dateReservation;
    private Integer nombrePersonnes;
    private String statut; // CONFIRMEE, EN_ATTENTE, ANNULEE

    @ManyToOne
    private Client client;
}
