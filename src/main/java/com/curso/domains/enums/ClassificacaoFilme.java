package com.curso.domains.enums;

public enum ClassificacaoFilme {
    LIVRE(0,"LIVRE"),
    DEZ_ANOS(1,"10 anos"),
    DOZE_ANOS(2,"12 anos"),
    QUATORZE_ANOS(3,"13 anos"),
    DEZESSEIS_ANOS(4,"14 anos"),
    DEZOITO_ANOS(5,"18 anos");

    private int id;
    private String descricao;

    ClassificacaoFilme(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public static ClassificacaoFilme toEnum(Integer id) {
        if (id == null) return null;

        for (ClassificacaoFilme x : ClassificacaoFilme.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Classificação do filme invalida: " + id);
    }
}


