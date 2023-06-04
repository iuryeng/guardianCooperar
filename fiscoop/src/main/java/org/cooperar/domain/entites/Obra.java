package org.cooperar.domain.entites;

import org.cooperar.domain.enums.TipoObra;

import java.util.ArrayList;
import java.util.List;

public class Obra {

    private String id;
    private TipoObra tipo;
    private  List<Problema> problemas;
    private List<Fiscalizacao> fiscalizacoes;
    private Progresso progresso;

    private List<Fase> fases;
    private Fase faseAtual;

    public Obra(String id, TipoObra tipo) {
        this.id = id;
        this.tipo = tipo;
        this.problemas = new ArrayList<>();
        this.fiscalizacoes = new ArrayList<>();
        this.progresso = new Progresso();
        this.fases = new ArrayList<>();
        this.faseAtual = null; // A fase atual será definida pelo construtor adicional
    }

    public Obra(String id, TipoObra tipo, Fase faseInicial) {
        this(id, tipo);
        this.faseAtual = faseInicial;
    }

    public Obra() {
        this.problemas = new ArrayList<>();
        this.fiscalizacoes = new ArrayList<>();
        this.progresso = new Progresso();
        this.fases = new ArrayList<>();
        this.faseAtual = null;
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

    public void adicionarFase(Fase fase) {
        fases.add(fase);
    }

    public List<Fiscalizacao> getFiscalizacoes() {
        return fiscalizacoes;
    }

    public Progresso getProgresso() {
        return progresso;
    }

    public void setProgresso(Progresso progresso) {
        this.progresso = progresso;
    }

    public void adicionarFiscalizacao(Fiscalizacao fiscalizacao) {
        fiscalizacoes.add(fiscalizacao);
    }

    public List<Fase> getFases() {
        return fases;
    }

    public Fase getFaseAtual() {
        return faseAtual;
    }

    public void setFaseAtual(Fase faseAtual) {
        this.faseAtual = faseAtual;
    }

    public TipoObra getTipo() {
        return tipo;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void setTipo(TipoObra tipo) {
        this.tipo = tipo;
    }
}
