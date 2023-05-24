package org.cooperar.domain.enums;

public enum StatusProgresso {
    NAO_INICIADA("Não Iniciada"),
    EM_EXECUCAO("Em Execução"),
    PARALISADA("Paralisada"),
    CONCLUIDA("Concluída");

    private final String descricao;

    StatusProgresso(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}