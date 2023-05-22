package org.cooperar.domain.entites;

import java.util.ArrayList;
import java.util.List;

public class Obra {

    private final String id;
    private final List<Problema> problemas;
    private final List<Fiscalizacao> fiscalizacoes;
    private  Progresso progresso;

    public Obra(String id) {
        this.id = id;
        this.problemas = new ArrayList<>();
        this.fiscalizacoes = new ArrayList<>();
        this.progresso = new Progresso();
    }

    public String getId() {
        return id;
    }

    public List<Problema> getProblemas() {
        return problemas;
    }

    public void adicionarProblema(Problema problema) {
        problemas.add(problema);
    }

    public List<Fiscalizacao> getFiscalizacoes() {
        return fiscalizacoes;
    }

    public void adicionarFiscalizacao(Fiscalizacao fiscalizacao) {
        fiscalizacoes.add(fiscalizacao);
    }

    public Progresso getProgresso() {
        return progresso;
    }

    public void setProgresso(Progresso progresso) {
        this.progresso = progresso;
    }


}
