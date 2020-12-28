//package com.devex.eventsourcing.repository;
//
//import com.devex.domain.BankAccount;
//import com.mongodb.client.FindIterable;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.model.Filters;
//import com.mongodb.client.result.InsertOneResult;
//
//import javax.inject.Singleton;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.StreamSupport;
//
//@Singleton
//public class BankAccountStateRespository {
//
//    private final MongoCollection<BankAccount> collection;
//
//    public BankAccountStateRespository(MongoClient mongoClient) {
//        collection = mongoClient.getDatabase("BankAccounts").getCollection("BankAccount", BankAccount.class);
//    }
//
//    public String addAccount(BankAccount account){
//        InsertOneResult result = collection.insertOne(account);
//        return result.getInsertedId().asString().toString();
//    }
//
//    public List<BankAccount> getBankAccounts() {
//        FindIterable<BankAccount> events = collection.find();
//        return StreamSupport.stream(events.spliterator(),false).collect(Collectors.toList());
//    }
//
//    public void substractSaldo(long id, double saldo) {
//        collection.updateOne(Filters.eq("id", id), Filters.eq("saldo", saldo));
//    }
//    public void addSaldo(long id, double saldo) {
//        collection.updateOne(Filters.eq("id", id), Filters.eq("saldo", saldo));
//    }
//}
