package com.hbr.service;

import com.hbr.model.Client;
import com.hbr.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client updated) {
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Client introuvable"));

        client.setNom(updated.getNom());
        client.setPrenoms(updated.getPrenoms());
        client.setSexe(updated.getSexe());
        client.setDateNaissance(updated.getDateNaissance());
        client.setTelephone(updated.getTelephone());
        client.setEmail(updated.getEmail());
        client.setPhoto(updated.getPhoto());
        client.setProfession(updated.getProfession());
        client.setDomicile(updated.getDomicile());

        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
