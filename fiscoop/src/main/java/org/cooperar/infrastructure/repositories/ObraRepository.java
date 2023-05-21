package org.cooperar.infrastructure.repositories;

import org.cooperar.domain.entites.Obra;

public interface ObraRepository {
    void save(Obra obra);
    Obra findById(String id);
}