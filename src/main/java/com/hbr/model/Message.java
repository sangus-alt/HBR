// src/main/java/com/hbr/model/Message.java
package com.hbr.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenu;
    private LocalDateTime dateEnvoi;

    @ManyToOne
    private User expediteur;

    @ManyToOne
    private User destinataire;
}
