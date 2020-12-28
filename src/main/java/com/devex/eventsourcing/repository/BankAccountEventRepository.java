package com.devex.eventsourcing.repository;

import com.devex.eventsourcing.domain.Event;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Sorts;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class BankAccountEventRepository {

    private final MongoDatabase database;

    public BankAccountEventRepository(MongoClient mongoClient) {

        database = mongoClient.getDatabase("BankAccountEvents");
    }

    public void addEvent(Event event){
        database.getCollection(event.getOwnerId(), Event.class).insertOne(event);
    }

    public List<Event> getEvents(String id) {
        FindIterable<Event> events = database.getCollection(id, Event.class).find();
        return StreamSupport.stream(events.spliterator(),false).collect(Collectors.toList());
    }

    public Event getLastEvent(String id) {
         return database.getCollection(id, Event.class)
                 .aggregate(Collections.singletonList(
                         Aggregates.sort(Sorts.descending("objectId"))
                 )).
                 first();
    }

    public List<String> getAllAccounts() {
        MongoIterable<String> collections = database.listCollectionNames();
        return StreamSupport.stream(collections.spliterator(), false).collect(Collectors.toList());
    }


}
