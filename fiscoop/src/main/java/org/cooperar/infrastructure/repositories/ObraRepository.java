package org.cooperar.infrastructure.repositories;

import org.cooperar.domain.entites.Obra;

import java.util.List;

public interface ObraRepository {
    void save(Obra obra);
    Obra findById(String id);

    List<Obra> findAll();
}