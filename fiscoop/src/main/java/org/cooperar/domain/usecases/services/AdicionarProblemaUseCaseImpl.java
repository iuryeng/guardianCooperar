package org.cooperar.domain.usecases.services;

import org.cooperar.domain.entites.Obra;
import org.cooperar.domain.entites.Problema;
import org.cooperar.domain.usecases.interfaces.AdicionarProblemaUseCase;
import org.cooperar.infrastructure.repositories.ObraRepository;

public class AdicionarProblemaUseCaseImpl implements AdicionarProblemaUseCase {
    private final ObraRepository obraRepository;

    public AdicionarProblemaUseCaseImpl(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    @Override
    public void execute(String idObra, Problema problema) {
        Obra obra = obraRepository.findById(idObra);
        if (obra != null && problema != null) {
            obra.adicionarProblema(problema);
            obraRepository.save(obra);
        }
    }
}
