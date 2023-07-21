package com.example.clients.client;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepo extends CrudRepository<Client, Long> {
    Optional<Client> findByPassportNumber(String passportNumber);
}
