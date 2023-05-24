package org.cooperar.domain.entites;

import org.cooperar.domain.enums.StatusAtividade;

import java.util.ArrayList;
import java.util.List;

public class Atividade {

    private final String idAtividade;
    private String nome;
    private StatusAtividade status;
    private Double precoUnitario;
    private Double precoTotal;
    private List<Material> materiais;

    public Atividade(String idAtividade, String nome) {
        this.idAtividade = idAtividade;
        this.nome = nome;
        this.precoUnitario = null;
        this.materiais = new ArrayList<>();
        this.status = StatusAtividade.NAO_INICIADA;
        this.precoTotal = 0.0;
    }



    public StatusAtividade getStatus() {
        return status;
    }

    public Atividade(String idAtividade) {
        this.idAtividade = idAtividade;
    }

    public void iniciar() {
        // Implementar lógica para iniciar a atividade
    }

    public void concluir() {
        // Implementar lógica para concluir a atividade
    }

    public void setStatus(StatusAtividade statusAtividade) {
        this.status = statusAtividade;
    }
}
