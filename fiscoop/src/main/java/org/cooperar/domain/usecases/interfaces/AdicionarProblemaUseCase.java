package org.cooperar.domain.usecases.interfaces;
import org.cooperar.domain.entites.Problema;

public interface AdicionarProblemaUseCase {
    void execute(String idObra, Problema problema);
}
