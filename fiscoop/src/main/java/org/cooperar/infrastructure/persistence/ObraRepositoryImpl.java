package org.cooperar.infrastructure.persistence;

import org.cooperar.domain.entites.Obra;
import org.cooperar.infrastructure.repositories.ObraRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ObraRepositoryImpl implements ObraRepository {
    private final Map<String, Obra> obras = new HashMap<>();

    @Override
    public void save(Obra obra) {
        obras.put(obra.getId(), obra);
    }

    @Override
    public Obra findById(String id) {
        return obras.getOrDefault(id, null);
    }

    @Override
    public List<Obra> findAll() {
        return new ArrayList<>(obras.values());
    }

}