package com.hbr.service;

import com.hbr.model.Fournisseur;
import com.hbr.repository.FournisseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FournisseurService {

    private final FournisseurRepository fournisseurRepository;

    public List<Fournisseur> getAll() {
        return fournisseurRepository.findAll();
    }

    public Fournisseur create(Fournisseur f) {
        return fournisseurRepository.save(f);
    }

    public void delete(Long id) {
        fournisseurRepository.deleteById(id);
    }
}
