package com.hbr.controller;

import com.hbr.model.Stock;
import com.hbr.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping
    public List<Stock> getAll() {
        return stockService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getById(@PathVariable Long id) {
        return ResponseEntity.ok(stockService.getById(id));
    }

    @PostMapping
    public Stock create(@RequestBody Stock stock) {
        return stockService.create(stock);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        stockService.delete(id);
        return ResponseEntity.ok().build();
    }
}
