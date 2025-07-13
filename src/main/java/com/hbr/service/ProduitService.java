package com.hbr.service;

import com.hbr.model.Produit;
import com.hbr.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProduitService {

    private final ProduitRepository produitRepository;

    public List<Produit> getAll() {
        return produitRepository.findAll();
    }

    public Produit create(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit update(Long id, Produit updated) {
        Produit p = produitRepository.findById(id).orElseThrow();
        p.setNom(updated.getNom());
        p.setDescription(updated.getDescription());
        p.setPhoto(updated.getPhoto());
        p.setPrixAchat(updated.getPrixAchat());
        p.setPrixVente(updated.getPrixVente());
        p.setCategorie(updated.getCategorie());
        p.setMagasin(updated.getMagasin());
        return produitRepository.save(p);
    }

    public void delete(Long id) {
        produitRepository.deleteById(id);
    }
}
