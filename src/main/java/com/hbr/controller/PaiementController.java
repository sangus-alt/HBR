package com.hbr.controller;

import com.hbr.model.Paiement;
import com.hbr.service.PaiementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@RequiredArgsConstructor
public class PaiementController {

    private final PaiementService paiementService;

    @GetMapping
    public List<Paiement> getAll() {
        return paiementService.getAll();
    }

    @PostMapping
    public Paiement create(@RequestBody Paiement paiement) {
        return paiementService.create(paiement);
    }
}
