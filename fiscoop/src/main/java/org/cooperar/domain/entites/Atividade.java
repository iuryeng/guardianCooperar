package org.cooperar.domain.entites;

import org.cooperar.domain.enums.StatusAtividade;

import java.util.ArrayList;
import java.util.List;

public class Atividade {

    private String idAtividade;
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

    public Atividade() {

    }

    public String getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(String idAtividade) {
        this.idAtividade = idAtividade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusAtividade getStatus() {
        return status;
    }

    public void setStatus(StatusAtividade statusAtividade) {
        this.status = statusAtividade;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public List<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<Material> materiais) {
        this.materiais = materiais;
    }

    public void iniciar() {
        // Implementar lógica para iniciar a atividade
    }

    public void concluir() {
        // Implementar lógica para concluir a atividade
    }
}
