package org.cooperar.domain.entites;

import org.cooperar.domain.enums.StatusFiscalizacao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Fiscalizacao {
    private Obra obra;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Servidor engenheiroResponsavel;
    private List<Servidor> equipe;
    private StatusFiscalizacao status;


    public Fiscalizacao(Obra obra, LocalDate dataInicio, LocalDate dataFim, Servidor engenheiroResponsavel, List<Servidor> equipe) {
        this.obra = obra;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.engenheiroResponsavel = engenheiroResponsavel;
        this.status = StatusFiscalizacao.PENDENTE;
        this.equipe = new ArrayList<>(); // Initialize the equipe list
    }


    public Fiscalizacao() {

    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public void setEngenheiroResponsavel(Servidor engenheiroResponsavel){
        this.engenheiroResponsavel = engenheiroResponsavel;

    }

    public void adicionarMembroEquipe(Servidor servidor) {
        equipe.add(servidor);
    }

    public void setEquipe(List<Servidor> equipe) {
        this.equipe = equipe;
    }
}
