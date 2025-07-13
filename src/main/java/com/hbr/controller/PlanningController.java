package com.hbr.controller;

import com.hbr.model.Planning;
import com.hbr.service.PlanningService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plannings")
@RequiredArgsConstructor
public class PlanningController {

    private final PlanningService planningService;

    @GetMapping
    public List<Planning> getAll() {
        return planningService.getAll();
    }

    @PostMapping
    public Planning save(@RequestBody Planning planning) {
        return planningService.save(planning);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        planningService.delete(id);
        return ResponseEntity.ok().build();
    }
}
