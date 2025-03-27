package com.curso.domains;

import com.curso.domains.dtos.GerenteDTO;
import com.curso.domains.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@DiscriminatorValue("GERENTE")
public class Gerente extends Pessoa{
        
    @JsonIgnore
    @OneToMany(mappedBy = "gerente")
    private List<ServiceOrder> serviceOrders = new ArrayList<>();

    public Gerente(){
        super();
        addTipoPessoa(TipoPessoa.GERENTE);
    }

       public Gerente(Long id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addTipoPessoa(TipoPessoa.GERENTE);
    }

    public Gerente(GerenteDTO obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.createdAt = obj.getCreatedAt();
        this.tipoPessoa = obj.getTipoPessoa().stream()
                .map( x -> x.getId()).collect(Collectors.toSet());
        addTipoPessoa(TipoPessoa.ATENDENTE);
        addTipoPessoa(TipoPessoa.GERENTE);
    }

    public List<ServiceOrder> getServiceOrders() {
        return serviceOrders;
    }
    
    public void setServiceOrders(List<ServiceOrder> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }
}