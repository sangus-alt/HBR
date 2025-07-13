package com.hbr.service;

import com.hbr.model.ParametreSysteme;
import com.hbr.repository.ParametreSystemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParametreSystemeService {

    private final ParametreSystemeRepository repository;

    public List<ParametreSysteme> getAll() {
        return repository.findAll();
    }

    public ParametreSysteme save(ParametreSysteme p) {
        return repository.save(p);
    }
}
