package org.cooperar.domain.usecases.services;

import org.cooperar.domain.entites.Fiscalizacao;
import org.cooperar.domain.entites.Obra;
import org.cooperar.domain.usecases.interfaces.AdicionarFiscalizacaoUseCase;
import org.cooperar.infrastructure.repositories.ObraRepository;

public class AdicionarFiscalizacaoUseCaseImpl implements AdicionarFiscalizacaoUseCase {
    private ObraRepository obraRepository;

    public AdicionarFiscalizacaoUseCaseImpl(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    @Override
    public void execute(String obraId, Fiscalizacao fiscalizacao) {
        Obra obra = obraRepository.findById(obraId);
        if (obra != null) {
            obra.adicionarFiscalizacao(fiscalizacao); // Associar a fiscalização à obra
            obraRepository.save(obra);
        }
    }
}