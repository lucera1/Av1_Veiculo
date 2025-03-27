package com.curso.domains;

import com.curso.domains.dtos.GrupoFilmeDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "grupofilme")
public class GrupoFilme {

    @JsonIgnore
    @OneToMany(mappedBy = "grupoFilme")
    private List<Filme> filmes = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_idgrupo")
    private Long idGrupoFilme;

    @Column(unique = true)
    @NotNull
    @NotBlank(message = "O título do filme não pode ser vazio")
    private String nome;

    public GrupoFilme() {
    }

    public GrupoFilme(Long idGrupoFilme, String nome) {
        this.idGrupoFilme = idGrupoFilme;
        this.nome = nome;
    }

    public GrupoFilme(GrupoFilmeDTO dto){
        this.idGrupoFilme = dto.getIdGrupoFilme();
        this.nome = dto.getNome();
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public Long getIdGrupoFilme() {
        return idGrupoFilme;
    }

    public void setIdGrupoFilme(Long idGrupoFilme) {
        this.idGrupoFilme = idGrupoFilme;
    }

    public @NotNull @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotNull @NotBlank String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoFilme that = (GrupoFilme) o;
        return idGrupoFilme == that.idGrupoFilme && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGrupoFilme, nome);
    }
}
