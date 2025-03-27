package com.curso.domains.dtos;

import com.curso.domains.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClienteDTO {

    private Long idCliente;

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

    public ClienteDTO(){}

    public ClienteDTO(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.endereco = cliente.getEndereco();
        this.idade = cliente.getIdade();
        this.telefone = cliente.getTelefone();
    }

    public @NotNull(message = "O ID do cliente não pode ser nulo") Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(@NotNull(message = "O ID do cliente não pode ser nulo") Long idCliente) {
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

    public @NotNull(message = "A idade do cliente é obrigatória") Integer getIdade() {
        return idade;
    }

    public void setIdade(@NotNull(message = "A idade do cliente é obrigatória") Integer idade) {
        this.idade = idade;
    }

    public @NotBlank(message = "O telefone do cliente não pode ser vazio") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "O telefone do cliente não pode ser vazio") String telefone) {
        this.telefone = telefone;
    }
}


