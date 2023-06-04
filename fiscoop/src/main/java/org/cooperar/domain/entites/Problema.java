package org.cooperar.domain.entites;

import org.cooperar.domain.enums.StatusProblema;

import java.util.Date;

public class Problema {
    private String descricao;
    private Date dataIdentificacao;
    private String severidade;
    private String acaoCorretiva;
    private Date dataResolucao;

    private StatusProblema status;

    public Problema(String descricao, Date dataIdentificacao, String severidade, String acaoCorretiva) {
        this.descricao = descricao;
        this.dataIdentificacao = dataIdentificacao;
        this.severidade = severidade;
        this.acaoCorretiva = acaoCorretiva;
    }

    public Problema(){

    }

    // Getters e Setters

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataIdentificacao() {
        return dataIdentificacao;
    }

    public void setDataIdentificacao(Date dataIdentificacao) {
        this.dataIdentificacao = dataIdentificacao;
    }

    public String getSeveridade() {
        return severidade;
    }

    public void setSeveridade(String severidade) {
        this.severidade = severidade;
    }

    public String getAcaoCorretiva() {
        return acaoCorretiva;
    }

    public void setAcaoCorretiva(String acaoCorretiva) {
        this.acaoCorretiva = acaoCorretiva;
    }

    public Date getDataResolucao() {
        return dataResolucao;
    }

    public void setDataResolucao(Date dataResolucao) {
        this.dataResolucao = dataResolucao;
    }

    public StatusProblema getStatus() {
        return status;
    }

    public void setStatus(StatusProblema status) {
        this.status = status;
    }
}
