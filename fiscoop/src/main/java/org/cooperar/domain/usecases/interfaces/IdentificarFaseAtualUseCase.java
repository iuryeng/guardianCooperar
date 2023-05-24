package org.cooperar.domain.usecases.interfaces;

import org.cooperar.domain.entites.Fase;

public interface IdentificarFaseAtualUseCase {
    Fase identificarFaseAtual(String obraId);

    void atualizarFaseAtual(String number, Fase fase2);
}