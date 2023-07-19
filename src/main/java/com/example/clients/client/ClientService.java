package com.example.clients.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepo;

    public Client createClient(String clientName) {
        return clientRepo.save(new Client(null, clientName));
    }

    public Client getAllClients(Long clientId) {
        return clientRepo.findById(clientId).orElseThrow();
    }

    public Iterable<Client> getAllClients() {
        return clientRepo.findAll();
    }
}
