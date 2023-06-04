package org.cooperar.domain.enums;

public enum StatusProblema {
    IDENTIFICADO("Identificado"),
    EM_ANALISE("Em análise"),
    EM_CORRECAO("Em correção"),
    RESOLVIDO("Resolvido");

    private String descricao;

    StatusProblema(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}