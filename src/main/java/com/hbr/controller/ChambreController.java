package com.hbr.controller;

import com.hbr.model.Chambre;
import com.hbr.service.ChambreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chambres")
@RequiredArgsConstructor
public class ChambreController {

    private final ChambreService chambreService;

    @GetMapping
    public List<Chambre> getAll() {
        return chambreService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chambre> getById(@PathVariable Long id) {
        return ResponseEntity.ok(chambreService.getById(id));
    }

    @PostMapping
    public Chambre save(@RequestBody Chambre chambre) {
        return chambreService.save(chambre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        chambreService.delete(id);
        return ResponseEntity.ok().build();
    }
}
