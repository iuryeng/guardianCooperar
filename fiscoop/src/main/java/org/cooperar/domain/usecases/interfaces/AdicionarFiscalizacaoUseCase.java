package org.cooperar.domain.usecases.interfaces;

import org.cooperar.domain.entites.Fiscalizacao;

public interface AdicionarFiscalizacaoUseCase {

    void execute(String obraId, Fiscalizacao fiscalizacao);
}
