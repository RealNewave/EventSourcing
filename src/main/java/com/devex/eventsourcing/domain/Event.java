package com.devex.eventsourcing.domain;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;
import java.time.LocalDateTime;


public class Event {

    private String ownerId;
    private ObjectId objectId;
    private LocalDateTime timestamp;
    private double saldo;
    private EventType eventType;

    public Event() {

    }

    public Event(String ownerId, double saldo, EventType eventType) {
        this.ownerId = ownerId;
        this.objectId = ObjectId.get();
        this.saldo = saldo;
        this.eventType = eventType;
        this.timestamp = LocalDateTime.now();
    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public double getSaldo() {
        return saldo;
    }

    public EventType getEventType() {
        return eventType;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + objectId + '\'' +
                ", timestamp=" + timestamp +
                ", saldo=" + saldo +
                ", eventType=" + eventType +
                '}';
    }
}
