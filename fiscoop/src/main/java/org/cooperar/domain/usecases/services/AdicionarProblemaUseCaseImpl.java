package org.cooperar.domain.usecases.services;


import org.cooperar.domain.entites.Obra;
import org.cooperar.domain.entites.Problema;
import org.cooperar.domain.usecases.interfaces.AdicionarProblemaUseCase;


public class AdicionarProblemaUseCaseImpl implements AdicionarProblemaUseCase {
    private Obra obra;

    public AdicionarProblemaUseCaseImpl(Obra obra) {
        this.obra = obra;
    }

    public void execute(Problema problema) {
        if (problema != null) {
            obra.adicionarProblema(problema);
        }
    }

}