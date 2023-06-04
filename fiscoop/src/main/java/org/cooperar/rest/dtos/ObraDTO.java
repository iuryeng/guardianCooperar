package org.cooperar.rest.dtos;

import org.cooperar.domain.entites.Fase;
import org.cooperar.domain.entites.Progresso;
import org.cooperar.domain.enums.TipoObra;

import java.util.List;

public class ObraDTO {
    private String id;
    private TipoObra tipo;

    private List<Fase> fases;

    private Progresso progresso;

    // Construtores, getters e setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoObra getTipo() {
        return tipo;
    }

    public void setTipo(TipoObra tipo) {
        this.tipo = tipo;
    }

    public void setProgresso(Progresso progresso){
        this.progresso = progresso;
    }


}
