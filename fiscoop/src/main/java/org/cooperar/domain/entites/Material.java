package org.cooperar.domain.entites;

public class Material {
    private final String nome;
    private final float quantidade;

    public Material(String nome, float quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public float getQuantidade() {
        return quantidade;
    }
}
