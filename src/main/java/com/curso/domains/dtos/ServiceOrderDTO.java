package com.curso.domains.dtos;

import com.curso.domains.ServiceOrder;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public class ServiceOrderDTO {

    private UUID id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate starDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;

    @NotNull(message = "O campo Título não pode ser nulo!")
    private String titleOS;

    @NotNull(message = "O campo Descrição não pode ser nulo!")
    private String description;
    
    @NotNull(message = "O campo Status não pode ser nulo!")
    private Integer statusPedido;

    @NotNull(message = "O campo Técnico não pode ser nulo!")
    private Long gerente;

    @NotNull(message = "O campo Usuário não pode ser nulo!")
    private Long atendente;

    private String nameGerente;
    private String nameAtendente;

    public ServiceOrderDTO() {
    }

    public ServiceOrderDTO(ServiceOrder serviceOrder) {
        this.id = serviceOrder.getId();
        this.starDate = serviceOrder.getStarDate();
        this.endDate = serviceOrder.getEndDate();
        this.titleOS = serviceOrder.getTitleOS();
        this.description = serviceOrder.getDescription();
        this.statusPedido = serviceOrder.getStatusPedido().getId();
        this.gerente = serviceOrder.getGerente().getId();
        this.atendente = serviceOrder.getAtendente().getId();
        this.nameGerente = serviceOrder.getGerente().getNome();
        this.nameAtendente = serviceOrder.getAtendente().getNome();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getStarDate() {
        return starDate;
    }

    public void setStarDate(LocalDate starDate) {
        this.starDate = starDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public @NotNull(message = "O campo Título não pode ser nulo!") String getTitleOS() {
        return titleOS;
    }

    public void setTitleOS(@NotNull(message = "O campo Título não pode ser nulo!") String titleOS) {
        this.titleOS = titleOS;
    }

    public @NotNull(message = "O campo Descrição não pode ser nulo!") String getDescription() {
        return description;
    }

    public void setDescription(@NotNull(message = "O campo Descrição não pode ser nulo!") String description) {
        this.description = description;
    }

    public @NotNull(message = "O campo Status não pode ser nulo!") Integer getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(@NotNull(message = "O campo Status não pode ser nulo!") Integer statusPedido) {
        this.statusPedido = statusPedido;
    }

    public @NotNull(message = "O campo Gerente não pode ser nulo!") Long getGerente() {
        return gerente;
    }

    public void setGerente(@NotNull(message = "O campo Gerente não pode ser nulo!") Long gerente) {
        this.gerente = gerente;
    }

    public @NotNull(message = "O campo Atendente não pode ser nulo!") Long getAtendente() {
        return atendente;
    }

    public void setAtendente(@NotNull(message = "O campo Atendente não pode ser nulo!") Long atendente) {
        this.atendente = atendente;
    }

    public String getNameGerente() {
        return nameGerente;
    }

    public void setNameGerente(String nameGerente) {
        this.nameGerente = nameGerente;
    }

    public String getNameAtendente() {
        return nameAtendente;
    }

    public void setNameAtendente(String nameAtendente) {
        this.nameAtendente = nameAtendente;
    }
}

