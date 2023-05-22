package org.cooperar.infrastructure.persistence;

import org.cooperar.domain.entites.Obra;
import org.cooperar.infrastructure.repositories.ObraRepository;

import java.util.HashMap;
import java.util.Map;

public class ObraRepositoryImpl implements ObraRepository {
    private final Map<String, Obra> obras = new HashMap<>();

    @Override
    public void save(Obra obra) {
        obras.put(obra.getId(), obra);
    }

    @Override
    public Obra findById(String id) {
        if (obras.containsKey(id)) {
            return obras.get(id);
        } else {
            throw new RuntimeException("Obra não encontrada com o ID: " + id);
        }
    }
}