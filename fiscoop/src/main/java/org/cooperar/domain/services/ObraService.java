package org.cooperar.domain.services;

import org.cooperar.domain.entites.Fase;
import org.cooperar.domain.entites.Obra;
import org.cooperar.domain.entites.Problema;
import org.cooperar.domain.entites.Progresso;
import org.cooperar.domain.usecases.interfaces.AdicionarProblemaUseCase;
import org.cooperar.domain.usecases.interfaces.IdentificarFaseAtualUseCase;
import org.cooperar.infrastructure.repositories.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraService {

    private final ObraRepository obraRepository;
    private final IdentificarFaseAtualUseCase identificarFaseAtualUseCase;

    private final AdicionarProblemaUseCase adicionarProblemaUseCase;

    @Autowired
    public ObraService(ObraRepository obraRepository, IdentificarFaseAtualUseCase identificarFaseAtualUseCase, AdicionarProblemaUseCase adicionarProblemaUseCase) {
        this.obraRepository = obraRepository;
        this.identificarFaseAtualUseCase = identificarFaseAtualUseCase;
        this.adicionarProblemaUseCase = adicionarProblemaUseCase;
    }

    public Fase identificarFaseAtual(String idObra) {
        return identificarFaseAtualUseCase.identificarFaseAtual(idObra);
    }

    public void adicionarProblema(String idObra, Problema problema) {
        adicionarProblemaUseCase.execute(idObra, problema);
    }

    public Obra buscarObraPorId(String idObra) {
        return obraRepository.findById(idObra);
    }


    public List<Obra> getAllObras() {
        return obraRepository.findAll();
    }

    public void criarObra(Obra obra) {
        Progresso progresso = new Progresso();
        obra.setProgresso(progresso);
        obraRepository.save(obra);
    }

    public void adicionarFase(String idObra, Fase fase) {
        Obra obra = obraRepository.findById(idObra);
        if (obra != null) {
            obra.adicionarFase(fase);
            obraRepository.save(obra);
        } else {
            throw new RuntimeException("Obra não encontrada com o ID: " + idObra);
        }
    }






}