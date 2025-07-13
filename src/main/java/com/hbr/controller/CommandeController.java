package com.hbr.controller;

import com.hbr.model.Commande;
import com.hbr.service.CommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
@RequiredArgsConstructor
public class CommandeController {

    private final CommandeService commandeService;

    @GetMapping
    public List<Commande> getAll() {
        return commandeService.getAll();
    }

    @PostMapping
    public Commande save(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        commandeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
