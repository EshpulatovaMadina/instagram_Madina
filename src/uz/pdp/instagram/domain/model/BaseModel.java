package uz.pdp.instagram.domain.model;

import java.util.UUID;

public abstract class BaseModel {
    {
        this.uuid = UUID.randomUUID();
    }
    protected UUID uuid;

    public UUID getUuid() {
        return uuid;
    }
}
