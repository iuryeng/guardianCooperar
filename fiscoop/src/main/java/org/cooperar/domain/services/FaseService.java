package org.cooperar.domain.services;

import org.cooperar.domain.entites.Fase;
import org.cooperar.infrastructure.repositories.FaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FaseService {
    private final FaseRepository faseRepository;

    @Autowired
    public FaseService(FaseRepository faseRepository) {
        this.faseRepository = faseRepository;
    }

    public Fase criarFase(Fase fase){
        return faseRepository.save(fase);
    }

    public Fase buscarFasePorId(String idFase) {
        return faseRepository.findById(idFase);
    }


    // outros métodos...
}
