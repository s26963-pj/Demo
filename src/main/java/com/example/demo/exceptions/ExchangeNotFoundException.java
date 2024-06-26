package com.example.demo.exceptions;

public class ExchangeNotFoundException extends RuntimeException{
    public ExchangeNotFoundException() {
        super("Exchange with that data has not been found");
    }
}
