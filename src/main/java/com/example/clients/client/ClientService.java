package com.example.clients.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private Rest rest;

    public Client putClient(String clientName, String passportNumber) {
        Client client = clientRepo.findByPassportNumber(passportNumber).orElse(new Client(null, clientName, passportNumber));
        client.setName(clientName);
        return clientRepo.save(client);
    }

    public Client getClient(Long clientId) {
        return clientRepo.findById(clientId).orElseThrow();
    }

    public Iterable<Client> getClient() {
        return clientRepo.findAll();
    }

    public Gift putClientGift(String clientName, String passportNumber, String orderAddress) {
        Client client = putClient(clientName, passportNumber);
        return rest.putGift(orderAddress, client);
    }

}
