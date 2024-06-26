package com.example.demo.service;

import com.example.demo.exceptions.ExchangeNotFoundException;
import com.example.demo.model.Exchange;
import com.example.demo.repository.ExchangeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class ExchangeService {

    private final WebClient webClient;
    private final ExchangeRepository exchangeRepository;

    public ExchangeService(WebClient webClient, ExchangeRepository exchangeRepository) {
        this.webClient = webClient;
        this.exchangeRepository = exchangeRepository;
    }

    private final String formatJson = "?format=json";

    public Exchange getExchange(Long id) {
        Optional<Exchange> exchange = exchangeRepository.findById(id);
        if (exchange.isPresent()) {
            return exchange.get();
        } else {
            throw new ExchangeNotFoundException();
        }
    }

    public void saveExchange(String exchangeCode) {
        Exchange exchange = webClient.get()
                .uri("http://api.nbp.pl/api/exchangerates/rates/a/" + exchangeCode + formatJson)
                .retrieve()
                .bodyToMono(Exchange.class)
                .block();
        if (exchange != null) {
            exchangeRepository.save(exchange);
        } else {
            throw new ExchangeNotFoundException();
        }

    }
}
