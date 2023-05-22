package org.cooperar.domain.usecases.services;

import org.cooperar.domain.entites.Obra;
import org.cooperar.domain.entites.Progresso;
import org.cooperar.domain.usecases.interfaces.AcompanharProgressoUseCase;
import org.cooperar.infrastructure.repositories.ObraRepository;

public class AcompanharProgressoUseCaseImpl implements AcompanharProgressoUseCase {
    private final ObraRepository obraRepository;

    public AcompanharProgressoUseCaseImpl(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    @Override
    public Progresso execute(String idObra) {
        Obra obra = obraRepository.findById(idObra);
        return obra != null ? obra.getProgresso() : null;
    }
}
