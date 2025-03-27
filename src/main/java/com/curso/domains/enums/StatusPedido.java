package com.curso.domains.enums;

public enum StatusPedido {

    ABERTO(0, "ABERTO"), CONCLUIDO(1, "CONCLUIDO"),
    CANCELADO(2, "CANCELADO");

    private Integer id;
    private String statusPedido;

    StatusPedido(Integer id, String statusPedido) {
            this.id = id;
            this.statusPedido = statusPedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public static StatusPedido toEnum(Integer id){
        if(id == null) return null;
        for(StatusPedido x : StatusPedido.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Status Inválido!");
    }
}