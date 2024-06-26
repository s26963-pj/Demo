package com.example.demo.controller;

import com.example.demo.model.Exchange;
import com.example.demo.service.ExchangeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {
    private ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Exchange> getExchangeById(@PathVariable Long id) {
        return ResponseEntity.ok(exchangeService.getExchange(id));
    }

    @PostMapping("/post/{exchangeCode}")
    public void saveExchange(@PathVariable String exchangeCode) {
        exchangeService.saveExchange(exchangeCode);
    }
}
