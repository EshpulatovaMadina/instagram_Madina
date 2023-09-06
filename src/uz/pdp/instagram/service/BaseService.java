package uz.pdp.instagram.service;

import uz.pdp.instagram.domain.DTO.BaseResponce;

import java.util.UUID;

public interface BaseService<CD,RD> {
    BaseResponce add (CD cd);
    int remove(RD rd);
    void remove (UUID uuid);
}
