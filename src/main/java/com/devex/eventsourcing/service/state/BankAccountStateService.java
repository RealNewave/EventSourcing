package com.devex.eventsourcing.service.state;//package com.devex.service.state;
//
//import com.devex.domain.BankAccount;
//import com.devex.repository.BankAccountStateRespository;
//import io.micronaut.http.HttpResponse;
//import io.micronaut.http.client.exceptions.HttpClientResponseException;
//
//import javax.inject.Inject;
//import javax.inject.Singleton;
//
//@Singleton
//public class BankAccountStateService {
//
//    @Inject
//    private BankAccountStateRespository bankAccountStateRespository;
//
//    public void substractSaldo(long id, double saldo) {
//        bankAccountStateRespository.substractSaldo(id, saldo);
//    }
//
//    public void addSaldo(long id, double saldo) {
//        bankAccountStateRespository.addSaldo(id,saldo);
//    }
//
//    public double getSaldoById(long id) {
//        BankAccount account = getBankAccount(id);
//        return account.getSaldo();
//    }
//
//    public void createAccount(long id) {
//        bankAccountStateRespository.addAccount(new BankAccount(id));
//    }
//
//    private BankAccount getBankAccount(long id) {
//        return bankAccountStateRespository.getAccountById(id);
//    }
//}
