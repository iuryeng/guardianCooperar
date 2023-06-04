package org.cooperar.infrastructure.repositories;


import org.cooperar.domain.entites.Fase;

public interface FaseRepository {
    Fase save(Fase fase);
    Fase findById(String id);

    // Outros métodos de consulta e manipulação de dados das fases
}