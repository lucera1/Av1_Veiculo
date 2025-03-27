package com.curso.domains;

import com.curso.domains.dtos.AtendenteDTO;
import com.curso.domains.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@DiscriminatorValue("ATENDENTE")
public class Atendente extends Pessoa{

    @JsonIgnore
    @OneToMany(mappedBy = "atendente")
    private List<ServiceOrder> serviceOrders = new ArrayList<>();

    public Atendente(Long id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addTipoPessoa(TipoPessoa.ATENDENTE);
    }

    public Atendente(AtendenteDTO obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.createdAt = obj.getCreatedAt();
        this.tipoPessoa = obj.getTipoPessoa().stream()
                .map( x -> x.getId()).collect(Collectors.toSet());
        addTipoPessoa(TipoPessoa.ATENDENTE);

    }

    public Atendente(){
        super();
        addTipoPessoa(TipoPessoa.ATENDENTE);
    }

    public List<ServiceOrder> getServiceOrders() {
        return serviceOrders;
    }

    public void setServiceOrders(List<ServiceOrder> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }
}


