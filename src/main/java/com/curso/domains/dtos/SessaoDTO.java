package com.curso.domains.dtos;

import com.curso.domains.Sessao;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public class SessaoDTO {

    private Long idSessao;

    @NotNull(message = "A data e horário da sessão não podem ser nulos")
    @Future(message = "A data e horário devem ser no futuro")
    private LocalDateTime dataHora;

    @NotNull(message = "O número da sala é obrigatório")
    @Positive(message = "O número da sala deve ser positivo")
    private int sala;

    @NotNull(message = "O filme da sessão não pode ser nulo")
    private FilmeDTO filme;

    public SessaoDTO(){
    }

    public SessaoDTO(Sessao sessao) {
        this.idSessao = sessao.getIdSessao();
        this.dataHora = sessao.getDataHora();
        this.sala = sessao.getSala();
        if (sessao.getFilme() != null) {
            this.filme = new FilmeDTO(sessao.getFilme());
        }
    }

    public Long getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(Long idSessao) {
        this.idSessao = idSessao;
    }

    public @NotNull(message = "A data e horário da sessão não podem ser nulos") @Future(message = "A data e horário devem ser no futuro") LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(@NotNull(message = "A data e horário da sessão não podem ser nulos") @Future(message = "A data e horário devem ser no futuro") LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @NotNull(message = "O número da sala é obrigatório")
    @Positive(message = "O número da sala deve ser positivo")
    public int getSala() {
        return sala;
    }

    public void setSala(@NotNull(message = "O número da sala é obrigatório") @Positive(message = "O número da sala deve ser positivo") int sala) {
        this.sala = sala;
    }

    public @NotNull(message = "O filme da sessão não pode ser nulo") FilmeDTO getFilme() {
        return filme;
    }

    public void setFilme(@NotNull(message = "O filme da sessão não pode ser nulo") FilmeDTO filme) {
        this.filme = filme;
    }
}



