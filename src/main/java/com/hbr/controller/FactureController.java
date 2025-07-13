package com.hbr.controller;

import com.hbr.model.Facture;
import com.hbr.service.FactureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factures")
@RequiredArgsConstructor
public class FactureController {

    private final FactureService factureService;

    @GetMapping
    public List<Facture> getAll() {
        return factureService.getAll();
    }

    @PostMapping
    public Facture create(@RequestBody Facture facture) {
        return factureService.create(facture);
    }

    @PutMapping("/payee/{id}")
    public ResponseEntity<Facture> marquerPayee(@PathVariable Long id) {
        return ResponseEntity.ok(factureService.marquerCommePayee(id));
    }
}
