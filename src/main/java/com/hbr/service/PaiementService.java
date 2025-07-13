package com.hbr.service;

import com.hbr.model.Paiement;
import com.hbr.repository.PaiementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaiementService {

    private final PaiementRepository paiementRepository;

    public List<Paiement> getAll() {
        return paiementRepository.findAll();
    }

    public Paiement create(Paiement p) {
        return paiementRepository.save(p);
    }
}
