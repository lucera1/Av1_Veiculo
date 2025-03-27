package com.curso.domains;

import com.curso.domains.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Pessoa {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
        protected Long id;
        protected String nome;

        @Column(unique = true)
        protected String cpf;

        @Column(unique = true)
        protected String email;
        protected String senha;

        @JsonFormat(pattern = "dd/MM/yyyy")
        protected LocalDate createdAt = LocalDate.now();

        @ElementCollection(fetch = FetchType.EAGER)
        @CollectionTable(name = "perfis")
        protected Set<Integer> tipoPessoa = new HashSet<>();

        public Pessoa() { addTipoPessoa(TipoPessoa.ATENDENTE); }

    public Pessoa(Long id, String nome, String cpf, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Set<TipoPessoa> getTipoPessoa(){
        return tipoPessoa.stream().map(TipoPessoa::toEnum).collect(Collectors.toSet());
        }

    public void addTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa.add(tipoPessoa.getId());
    }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pessoa pessoa = (Pessoa) o;
            return Objects.equals(id, pessoa.id) && Objects.equals(cpf, pessoa.cpf);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, cpf);
        }
    }

