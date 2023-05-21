package org.cooperar.domain.entites;

import java.util.ArrayList;
import java.util.List;

public class Obra {

    private String id;
    private List<Problema> problemas;

    private List<Fiscalizacao> fiscalizacoes;

    public Obra(String id) {
        this.id = id;
        this.problemas = new ArrayList<>();
        this.fiscalizacoes = new ArrayList<>();
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

    // Métodos setters

    public void setId(String id) {
        this.id = id;
    }

    public void setProblemas(List<Problema> problemas) {
        this.problemas = problemas;
    }


    public List<Fiscalizacao> getFiscalizacoes() {
        return fiscalizacoes;
    }

    public void adicionarFiscalizacao(Fiscalizacao fiscalizacao) {
        this.fiscalizacoes.add(fiscalizacao);

    }
}
