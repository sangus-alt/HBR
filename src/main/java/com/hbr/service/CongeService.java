package com.hbr.service;

import com.hbr.model.Conge;
import com.hbr.repository.CongeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CongeService {

    private final CongeRepository congeRepository;

    public List<Conge> getAll() {
        return congeRepository.findAll();
    }

    public Conge save(Conge conge) {
        return congeRepository.save(conge);
    }

    public void delete(Long id) {
        congeRepository.deleteById(id);
    }
}
