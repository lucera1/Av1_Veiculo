package com.curso.domains;

import com.curso.domains.dtos.VeiculoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_veiculo")
    private Long id;

    @NotNull @NotBlank
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAquisicao = LocalDate.now();

    @NotNull
    private double valorAquisicao;

    @NotNull @NotBlank
    private String nomeProprietario;

    @NotNull @NotBlank
    @Column(unique = true)
    private String cpf;

    public Veiculo(){

    }



    public Veiculo(Long id, String descricao, LocalDate dataAquisicao, double valorAquisicao, String nomeProprietario, String cpf) {
        this.id = id;
        this.descricao = descricao;
        this.dataAquisicao = dataAquisicao;
        this.valorAquisicao = valorAquisicao;
        this.nomeProprietario = nomeProprietario;
        this.cpf = cpf;
    }

    public Veiculo(VeiculoDTO dto) {
        this.id = dto.getId();
        this.descricao = dto.getDescricao();
        this.dataAquisicao = dto.getDataAquisicao();
        this.valorAquisicao = dto.getValorAquisicao();
        this.nomeProprietario = dto.getNomeProprietario();
        this.cpf = dto.getCpf();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @NotBlank String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull @NotBlank String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    @NotNull
    public double getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao(@NotNull double valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    public @NotNull @NotBlank String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(@NotNull @NotBlank String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public @NotNull @NotBlank String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull @NotBlank String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Double.compare(valorAquisicao, veiculo.valorAquisicao) == 0 && Objects.equals(id, veiculo.id) && Objects.equals(descricao, veiculo.descricao) && Objects.equals(dataAquisicao, veiculo.dataAquisicao) && Objects.equals(nomeProprietario, veiculo.nomeProprietario) && Objects.equals(cpf, veiculo.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, dataAquisicao, valorAquisicao, nomeProprietario, cpf);
    }
}
