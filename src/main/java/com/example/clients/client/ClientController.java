package com.example.clients.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Api(value = "Клиенты",  tags={"Клиенты"})
@Slf4j
@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @ApiOperation(value = "Сохранение клиента", response = Long.class)
    @PostMapping("add")
    public Client createClient(@RequestParam String clientName) {
        return clientService.createClient(clientName);
    }
    @ApiOperation(value = "Получение клиента", response = Client.class)
    @GetMapping("get")
    public Client getClient(@RequestParam Long clientId) {
        return clientService.getAllClients(clientId);
    }

    @ApiOperation(value = "Получение клиентов")
    @GetMapping("get-all")
    public Iterable<Client> getClients() {
        return clientService.getAllClients();
    }
}
