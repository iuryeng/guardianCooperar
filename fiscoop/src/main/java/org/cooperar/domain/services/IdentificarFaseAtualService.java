package org.cooperar.domain.services;

import org.cooperar.domain.entites.Fase;
import org.cooperar.domain.usecases.interfaces.IdentificarFaseAtualUseCase;

public class IdentificarFaseAtualService {
    private final IdentificarFaseAtualUseCase identificarFaseAtualUseCase;

    public IdentificarFaseAtualService(IdentificarFaseAtualUseCase identificarFaseAtualUseCase) {
        this.identificarFaseAtualUseCase = identificarFaseAtualUseCase;
    }

    public Fase identificarFaseAtual(String obraId) {
        return identificarFaseAtualUseCase.identificarFaseAtual(obraId);
    }
}
