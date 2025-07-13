// src/main/java/com/hbr/model/Notification.java
package com.hbr.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String contenu;
    private Boolean lu;
    private LocalDateTime date;

    @ManyToOne
    private User utilisateur;
}
