package com.curso.domains;

import com.curso.domains.dtos.SessaoDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "sessao")
public class Sessao {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sessao")
    @SequenceGenerator(name = "seq_sessao", sequenceName = "seq_sessao", allocationSize = 1)
    private Long idSessao;

    @NotNull(message = "A data e horário da sessão não podem ser nulos")
    @Future(message = "A data e horário devem ser no futuro")
    private LocalDateTime dataHora;

    @Column(unique = true)
    @NotNull(message = "O número da sala é obrigatório")
    private Integer sala;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_filme")
    private Filme filme;



    public Sessao() {
    }


    public Sessao(Long idSessao, LocalDateTime dataHora, Integer sala, Filme filme) {
        this.idSessao = idSessao;
        this.dataHora = dataHora;
        this.sala = sala;
        this.filme = filme;
    }
    public Sessao(SessaoDTO dto) {
        this.idSessao = dto.getIdSessao();
        this.dataHora = dto.getDataHora();
        this.sala = dto.getSala();
        if (dto.getFilme() != null) {
            this.filme = new Filme(dto.getFilme());
        }
    }




    public Long getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(Long idSessao) {
        this.idSessao = idSessao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(Integer sala) {
        this.sala = sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sessao sessao = (Sessao) o;
        return idSessao == sessao.idSessao &&
                sala == sessao.sala &&
                Objects.equals(dataHora, sessao.dataHora) &&
                Objects.equals(filme, sessao.filme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSessao, dataHora, sala, filme);
    }

    @Override
    public String toString() {
        return "Sessao{" +
                "idSessao=" + idSessao +
                ", dataHora=" + dataHora +
                ", sala=" + sala +
                ", filme=" + filme +
                '}';
    }
}
