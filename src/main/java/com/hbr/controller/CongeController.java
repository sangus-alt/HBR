package com.hbr.controller;

import com.hbr.model.Conge;
import com.hbr.service.CongeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conges")
@RequiredArgsConstructor
public class CongeController {

    private final CongeService congeService;

    @GetMapping
    public List<Conge> getAll() {
        return congeService.getAll();
    }

    @PostMapping
    public Conge save(@RequestBody Conge conge) {
        return congeService.save(conge);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        congeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
