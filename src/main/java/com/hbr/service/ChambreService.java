package com.hbr.service;

import com.hbr.model.Chambre;
import com.hbr.repository.ChambreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChambreService {

    private final ChambreRepository chambreRepository;

    public List<Chambre> getAll() {
        return chambreRepository.findAll();
    }

    public Chambre getById(Long id) {
        return chambreRepository.findById(id).orElseThrow();
    }

    public Chambre save(Chambre c) {
        return chambreRepository.save(c);
    }

    public void delete(Long id) {
        chambreRepository.deleteById(id);
    }
}
