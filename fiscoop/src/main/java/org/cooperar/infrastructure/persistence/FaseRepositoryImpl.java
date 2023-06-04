package org.cooperar.infrastructure.persistence;

import org.cooperar.domain.entites.Fase;
import org.cooperar.infrastructure.repositories.FaseRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FaseRepositoryImpl implements FaseRepository {

    private final Map<String, Fase> fases = new HashMap<>();

    public Fase save(Fase fase) {
        fases.put(fase.getId(), fase);
        return fase;
    }

    public Fase findById(String id) {
        return fases.get(id);
    }

    public void deleteById(String id) {
        fases.remove(id);
    }

    // Implemente outros métodos do repositório conforme necessário

    // Exemplo de implementação de método adicional
    public List<Fase> findAll() {
        return new ArrayList<>(fases.values());
    }
}
