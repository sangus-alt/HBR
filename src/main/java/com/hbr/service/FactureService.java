package com.hbr.service;

import com.hbr.model.Facture;
import com.hbr.model.LigneFacture;
import com.hbr.repository.FactureRepository;
import com.hbr.repository.LigneFactureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FactureService {

    private final FactureRepository factureRepository;
    private final LigneFactureRepository ligneFactureRepository;

    public List<Facture> getAll() {
        return factureRepository.findAll();
    }

    public Facture create(Facture facture) {
        facture.setDateEmission(LocalDateTime.now());

        double total = facture.getLignes().stream()
                .mapToDouble(LigneFacture::getTotal).sum();

        facture.setMontantTotal(total);
        facture.setResteAPayer(total - facture.getMontantPaye());

        if (facture.getResteAPayer() <= 0) {
            facture.setStatut("PAYEE");
        } else {
            facture.setStatut("NON_PAYEE");
        }

        Facture saved = factureRepository.save(facture);
        facture.getLignes().forEach(lf -> {
            lf.setFacture(saved);
            ligneFactureRepository.save(lf);
        });

        return saved;
    }

    public Facture marquerCommePayee(Long id) {
        Facture f = factureRepository.findById(id).orElseThrow();
        f.setStatut("PAYEE");
        f.setResteAPayer(0.0);
        return factureRepository.save(f);
    }
}
