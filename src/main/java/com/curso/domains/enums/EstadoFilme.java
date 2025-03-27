package com.curso.domains.enums;

public enum EstadoFilme {
    NAO_INICIADO(0, "NÃO INICIADO"),
    EM_ANDAMENTO(1, "EM ANDAMENTO"),
    PAUSADO(2, "PAUSADO"),
    FINALIZADO(3, "FINALIZADO");

    private Integer id;
    private String situacao;

    EstadoFilme(Integer id,String situacao){
        this.id = id;
        this.situacao = situacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    public static EstadoFilme toEnum(Integer id){
        if(id==null) return null;
        for(EstadoFilme x : EstadoFilme.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Estado do filme invalido"+id);
    }
}

