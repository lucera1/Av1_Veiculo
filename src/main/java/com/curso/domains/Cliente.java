package com.curso.domains;

import com.curso.domains.dtos.ClienteDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_idcliente")
    private Long idCliente;

    @Column(unique = true)
    @NotBlank(message = "O nome do cliente não pode ser vazio")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "O CPF do cliente não pode ser vazio")
    @Size(min = 11, max = 11, message = "O CPF deve conter exatamente 11 dígitos")
    private String cpf;

    @NotBlank(message = "O e-mail do cliente não pode ser vazio")
    @Email(message = "E-mail inválido")
    private String email;

    @NotBlank(message = "O endereço do cliente não pode ser vazio")
    private String endereco;

    @NotNull(message = "A idade do cliente é obrigatória")
    private Integer idade;

    @NotBlank(message = "O telefone do cliente não pode ser vazio")
    private String telefone;

    public Cliente() {}

    public Cliente(Long idCliente, String nome, String cpf, String email, String endereco, Integer idade, String telefone) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.idade = idade;
        this.telefone = telefone;
    }
    public Cliente(ClienteDTO dto) {
        this.idCliente = dto.getIdCliente();
        this.nome = dto.getNome();
        this.cpf = dto.getCpf();
        this.email = dto.getEmail();
        this.endereco = dto.getEndereco();
        this.idade = dto.getIdade();
        this.telefone = dto.getTelefone();
    }


    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public @NotBlank(message = "O nome do cliente não pode ser vazio") @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome do cliente não pode ser vazio") @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O CPF do cliente não pode ser vazio") @Size(min = 11, max = 11, message = "O CPF deve conter exatamente 11 dígitos") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank(message = "O CPF do cliente não pode ser vazio") @Size(min = 11, max = 11, message = "O CPF deve conter exatamente 11 dígitos") String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank(message = "O e-mail do cliente não pode ser vazio") @Email(message = "E-mail inválido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O e-mail do cliente não pode ser vazio") @Email(message = "E-mail inválido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "O endereço do cliente não pode ser vazio") String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotBlank(message = "O endereço do cliente não pode ser vazio") String endereco) {
        this.endereco = endereco;
    }

    public @NotBlank(message = "O telefone do cliente não pode ser vazio") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "O telefone do cliente não pode ser vazio") String telefone) {
        this.telefone = telefone;
    }

    public @NotNull(message = "A idade do cliente é obrigatória") Integer getIdade() {
        return idade;
    }

    public void setIdade(@NotNull(message = "A idade do cliente é obrigatória") Integer idade) {
        this.idade = idade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return idCliente == cliente.idCliente && Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, cpf);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", idade=" + idade +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
