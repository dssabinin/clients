package com.example.clients.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Api(value = "Клиенты",  tags={"Клиенты"})
@Slf4j
@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @ApiOperation(value = "Сохранение клиента", response = Long.class)
    @PutMapping("clients")
    public Client putClient(@RequestParam String clientName,
                               @RequestParam String passportNumber) {
        return clientService.putClient(clientName, passportNumber);
    }

    @ApiOperation(value = "Сохранение клиента", response = Long.class)
    @PutMapping("clients/gift")
    public Gift putClientGift(@RequestParam String clientName,
                               @RequestParam String passportNumber,
                                @RequestParam String orderAddress) {
        return clientService.putClientGift(clientName, passportNumber, orderAddress);
    }

    @ApiOperation(value = "Получение клиента", response = Client.class)
    @GetMapping("clients/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @ApiOperation(value = "Получение клиентов")
    @GetMapping("clients")
    public Iterable<Client> getClients() {
        return clientService.getClient();
    }
}
