package com.devex.eventsourcing.service;

import com.devex.eventsourcing.domain.Event;
import com.devex.eventsourcing.domain.dto.TransferSaldoDTO;
import com.devex.eventsourcing.service.event.BankAccountEventService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BankAccountService {


    private final BankAccountEventService eventService;

    public BankAccountService(BankAccountEventService eventService) {
        this.eventService = eventService;
    }


    public void withdrawSaldo(String id, double saldo) {
        eventService.withdrawSaldo(id, saldo);
    }

    public void depositSaldo(String id, double saldo) {
        eventService.depositSaldo(id, saldo);
    }

    public Event getLastEvent(String id) {
        return eventService.getLastEvent(id);
    }

    public String createAccount() {
        return eventService.createAccount();
    }

    public List<Event> getEvents(String id){
        return eventService.getEvents(id);
    }

    public void transferSaldo(TransferSaldoDTO transferSaldoDTO) {
        String fromId = transferSaldoDTO.getFromId();
        String toId = transferSaldoDTO.getToId();
        double amount = transferSaldoDTO.getAmount();
        withdrawSaldo(fromId, amount);
        depositSaldo(toId, amount);
    }

    public List<String> getAllAccounts() {
        return eventService.getAllAccounts();
    }
}
