// src/main/java/com/hbr/model/User.java
package com.hbr.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;
    private String motDePasse;
    private String photo;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
