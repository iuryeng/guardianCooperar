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
    private String faseAnteriorId;  // Alterado para armazenar o ID da fase anterior.
    private Progresso progresso;


    public Fase(String id, String nome, LocalDate dataInicio, LocalDate dataFim) {
        this.id = id;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.atividades = new ArrayList<>();
        this.faseAnteriorId = null;  // Inicialmente nulo, deve ser definido separadamente.
        this.progresso = new Progresso();
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


    public String getFaseAnteriorId() {
        return faseAnteriorId;
    }

    public void setFaseAnteriorId(String faseAnteriorId) {
        this.faseAnteriorId = faseAnteriorId;
    }

    public Progresso getProgresso() {
        return progresso;
    }

    public void setProgresso(Progresso progresso) {
        this.progresso = progresso;
    }

    public void setId(String id) {
        this.id = id;
    }
}
