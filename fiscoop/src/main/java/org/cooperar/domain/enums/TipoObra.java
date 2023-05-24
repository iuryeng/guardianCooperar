package org.cooperar.domain.enums;

public enum TipoObra {

        CISTERNA("Cisterna"),
        PASSAGEM_MOLHADA("Passagem Molhada");

        private final String descricao;

        TipoObra(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }


}
