package com.devex.eventsourcing.controller;


import com.devex.eventsourcing.domain.Event;
import com.devex.eventsourcing.domain.dto.AccountDTO;
import com.devex.eventsourcing.domain.dto.TransferSaldoDTO;
import com.devex.eventsourcing.service.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/account")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    public List<AccountDTO> getAllAccounts(){
        return bankAccountService.getAllAccounts()
                .stream()
                .map(AccountDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Event getLastEvent(@PathVariable String id) {
        return bankAccountService.getLastEvent(id);
    }

    @GetMapping("/{id}/events")
    public List<Event> getEvents(@PathVariable String id){
        return bankAccountService.getEvents(id);
    }

    @PostMapping("/create")
    public AccountDTO createAccount() {
        return new AccountDTO(bankAccountService.createAccount());
    }

    @PostMapping("/{id}/deposit/{saldo}")
    public void depositSaldo(@PathVariable String id, @PathVariable double saldo) {
        bankAccountService.depositSaldo(id, saldo);
    }

    @PostMapping("/{id}/withdraw/{saldo}")
    public void withdrawSaldo(@PathVariable String id, @PathVariable double saldo) {
        bankAccountService.withdrawSaldo(id, saldo);
    }

    @PostMapping(value = "/transfer")
    public void transferSaldo(@RequestBody TransferSaldoDTO transferSaldoDTO){
        bankAccountService.transferSaldo(transferSaldoDTO);
    }


}
