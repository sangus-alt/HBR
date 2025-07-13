package com.hbr.service;

import com.hbr.model.Stock;
import com.hbr.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    public List<Stock> getAll() {
        return stockRepository.findAll();
    }

    public Stock getById(Long id) {
        return stockRepository.findById(id).orElseThrow();
    }

    public Stock create(Stock s) {
        return stockRepository.save(s);
    }

    public void delete(Long id) {
        stockRepository.deleteById(id);
    }
}
