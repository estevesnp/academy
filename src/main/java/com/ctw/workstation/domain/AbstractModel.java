package com.ctw.workstation.domain;

import java.util.UUID;

public class AbstractModel {
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
