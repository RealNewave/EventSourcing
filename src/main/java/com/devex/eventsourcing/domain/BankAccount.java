package com.devex.eventsourcing.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;

public class BankAccount {

    private long id;
    private double saldo;

    public BankAccount(long id) {
        this.id = id;
        this.saldo = 0.0;
    }

    public long getId() {
        return id;
    }

    public void addSaldo(double amount) {
        if (amount <= 0.0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cant add negative amount");
        }
        saldo += amount;
    }

    public void substractSaldo(double amount) {
        double newSaldo = saldo - amount;
        if (newSaldo < 0.0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not enough money to make request");
        }
        saldo = newSaldo;
    }

    public double getSaldo() {
        return saldo;
    }
}
