package com.curso.domains.dtos;

import com.curso.domains.Atendente;
import com.curso.domains.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AtendenteDTO {

    protected Long id;

    @NotNull(message = "O campo nome não pode ser nulo!")
    @NotBlank(message = "O campo nome não pode ser vazio!")
    protected String nome;
    
    @NotNull(message = "O campo CPF não pode ser nulo!")
    @CPF
    protected String cpf;

    @NotNull(message = "O campo e-mail não pode ser nulo!")
    @NotBlank(message = "O campo e-mail não pode ser vazio")
    protected String email;

    @NotNull(message = "O campo senha não pode ser nulo!")
    @NotBlank(message = "O campo senha não pode ser vazio")
    protected String senha;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate createdAt = LocalDate.now();

    protected Set<Integer> tipoPessoa = new HashSet<>();

    public AtendenteDTO(){

    }

    public AtendenteDTO(Atendente obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.createdAt = obj.getCreatedAt();
        this.tipoPessoa.stream().map(TipoPessoa:: toEnum).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String nome) {
        this.nome = nome;
    }


    public @NotNull(message = "O campo CPF não pode ser nulo!") @CPF String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull(message = "O campo CPF não pode ser nulo!") @CPF String cpf) {
        this.cpf = cpf;
    }

    public @NotNull(message = "O campo e-mail não pode ser nulo!") @NotBlank(message = "O campo e-mail não pode ser vazio") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull(message = "O campo e-mail não pode ser nulo!") @NotBlank(message = "O campo e-mail não pode ser vazio") String email) {
        this.email = email;
    }

    public @NotNull(message = "O campo senha não pode ser nulo!") @NotBlank(message = "O campo senha não pode ser vazio") String getSenha() {
        return senha;
    }

    public void setSenha(@NotNull(message = "O campo senha não pode ser nulo!") @NotBlank(message = "O campo senha não pode ser vazio") String senha) {
        this.senha = senha;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Set<TipoPessoa> getTipoPessoa() {
        return tipoPessoa == null ? Collections.emptySet() :
                tipoPessoa.stream().map(TipoPessoa :: toEnum).collect(Collectors.toSet());
    }

    public void addTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa.add(tipoPessoa.getId());
    }
}


