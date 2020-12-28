package com.devex.eventsourcing.domain.dto;


public class AccountDTO {

    private final String id;

    public AccountDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
