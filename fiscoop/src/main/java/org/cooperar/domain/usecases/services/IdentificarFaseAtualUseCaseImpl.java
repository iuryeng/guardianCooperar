package org.cooperar.domain.usecases.services;

import org.cooperar.domain.entites.Atividade;
import org.cooperar.domain.entites.Fase;
import org.cooperar.domain.entites.Obra;
import org.cooperar.domain.enums.StatusAtividade;
import org.cooperar.domain.usecases.interfaces.IdentificarFaseAtualUseCase;
import org.cooperar.infrastructure.repositories.ObraRepository;

public class IdentificarFaseAtualUseCaseImpl implements IdentificarFaseAtualUseCase {
    private final ObraRepository obraRepository;

    public IdentificarFaseAtualUseCaseImpl(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    public Fase identificarFaseAtual(String obraId) {
        Obra obra = obraRepository.findById(obraId);
        if (obra != null) {
            for (Fase fase : obra.getFases()) {
                if (!todasAtividadesConcluidas(fase)) {
                    return fase;
                }
            }
        }
        // Retorna a primeira fase com atividades incompletas ou null se a obra não for encontrada
        return null;
    }

    private boolean todasAtividadesConcluidas(Fase fase) {
        for (Atividade atividade : fase.getAtividades()) {
            if (atividade.getStatus() != StatusAtividade.CONCLUIDA) {
                return false;
            }
        }
        return true;
    }

    public void atualizarFaseAtual(String obraId, Fase fase) {
        Obra obra = obraRepository.findById(obraId);
        if (obra != null) {
            obra.setFaseAtual(fase);
            obraRepository.save(obra);
        }
    }
}
