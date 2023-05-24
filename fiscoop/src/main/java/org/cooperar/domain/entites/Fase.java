package org.cooperar.domain.entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fase {

    private String id;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<Atividade> atividades;
    private Fase faseAnterior;
    private Progresso progresso;

    public Fase(String id, String nome, LocalDate dataInicio, LocalDate dataFim) {
        this.id = id;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.atividades = new ArrayList<>();
        this.faseAnterior = null;
        this.progresso = new Progresso();
    }

    public Fase() {
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void adicionarAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    public Fase getFaseAnterior() {
        return faseAnterior;
    }

    public void setFaseAnterior(Fase faseAnterior) {
        this.faseAnterior = faseAnterior;
    }

    public Progresso getProgresso() {
        return progresso;
    }

    public void setProgresso(Progresso progresso) {
        this.progresso = progresso;
    }
}
