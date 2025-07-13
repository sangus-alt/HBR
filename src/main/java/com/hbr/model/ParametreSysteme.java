// src/main/java/com/hbr/model/ParametreSysteme.java
package com.hbr.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParametreSysteme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String langue;
    private String theme; // light, dark
    private String nomStructure;
    private String logoStructure;

    private Double tauxTVA;
    private Double tauxService;
    private Boolean numerotationAuto;

    private Boolean multiAgence;
}
