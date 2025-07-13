package com.hbr.controller;

import com.hbr.model.ParametreSysteme;
import com.hbr.service.ParametreSystemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parametres")
@RequiredArgsConstructor
public class ParametreSystemeController {

    private final ParametreSystemeService parametreSystemeService;

    @GetMapping
    public List<ParametreSysteme> getAll() {
        return parametreSystemeService.getAll();
    }

    @PostMapping
    public ParametreSysteme save(@RequestBody ParametreSysteme p) {
        return parametreSystemeService.save(p);
    }
}
