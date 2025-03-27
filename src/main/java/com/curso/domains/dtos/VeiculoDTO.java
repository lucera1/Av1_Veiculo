package com.curso.domains.dtos;

import com.curso.domains.Veiculo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
public class VeiculoDTO{
    private Long id;

    @NotNull (message = "O campo não pode ser nulo!")
    @NotBlank (message = "O campo não pode estar em branco!")
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAquisicao = LocalDate.now();

    @NotNull (message = "O campo não pode ser nulo!")
    private double valorAquisicao;

    @NotNull (message = "O campo não pode ser nulo!")
    @NotBlank (message = "O campo não pode estar em branco!")
    private String nomeProprietario;

    @NotNull (message = "O campo não pode ser nulo!")
    @NotBlank (message = "O campo não pode estar em branco!")
    private String cpf;

    public VeiculoDTO() {
    }

    public VeiculoDTO(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.descricao = veiculo.getDescricao();
        this.dataAquisicao = veiculo.getDataAquisicao();
        this.valorAquisicao = veiculo.getValorAquisicao();
        this.nomeProprietario = veiculo.getNomeProprietario();
        this.cpf = veiculo.getCpf();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "O campo não pode ser nulo!") @NotBlank(message = "O campo não pode estar em branco!") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo não pode ser nulo!") @NotBlank(message = "O campo não pode estar em branco!") String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    @NotNull(message = "O campo não pode ser nulo!")
    public double getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao(@NotNull(message = "O campo não pode ser nulo!") double valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    public @NotNull(message = "O campo não pode ser nulo!") @NotBlank(message = "O campo não pode estar em branco!") String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(@NotNull(message = "O campo não pode ser nulo!") @NotBlank(message = "O campo não pode estar em branco!") String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public @NotNull(message = "O campo não pode ser nulo!") @NotBlank(message = "O campo não pode estar em branco!") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull(message = "O campo não pode ser nulo!") @NotBlank(message = "O campo não pode estar em branco!") String cpf) {
        this.cpf = cpf;
    }
}

