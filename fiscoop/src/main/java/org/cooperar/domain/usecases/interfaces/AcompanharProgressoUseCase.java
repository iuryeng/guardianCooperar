package org.cooperar.domain.usecases.interfaces;

import org.cooperar.domain.entites.Progresso;

public interface AcompanharProgressoUseCase {
    Progresso execute(String idObra);
}

