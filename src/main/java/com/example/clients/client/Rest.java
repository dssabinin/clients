package com.example.clients.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class Rest {

    private RestTemplate restTemplate;
    @Autowired
    Rest(RestTemplateBuilder builder) {
        this.restTemplate = builder
                .build();
    }

    public Gift putGift(String clientAddress, Client client) {
        UriBuilder uriBuilder = UriComponentsBuilder.fromUriString("http://localhost:8091/orders/gift");
        uriBuilder.queryParam("clientAddress", clientAddress);
        uriBuilder.queryParam("clientId", client.getId());
        URI uri = uriBuilder.build();
        System.out.println(uri.toString());
        Gift response = this.restTemplate.getForObject(uri, Gift.class);
        return response;
    }
}