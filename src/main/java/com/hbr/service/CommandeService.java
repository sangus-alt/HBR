package com.hbr.service;

import com.hbr.model.Commande;
import com.hbr.repository.CommandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandeService {

    private final CommandeRepository commandeRepository;

    public List<Commande> getAll() {
        return commandeRepository.findAll();
    }

    public Commande save(Commande c) {
        return commandeRepository.save(c);
    }

    public void delete(Long id) {
        commandeRepository.deleteById(id);
    }
}
