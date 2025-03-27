package com.curso.domains;


import com.curso.domains.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "serviceorder")
public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate starDate = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;

    private String titleOS;
    private String description;
    private StatusPedido orderStatus;

    @ManyToOne
    @JoinColumn(name = "idgerente")
    private Gerente gerente;

    @ManyToOne
    @JoinColumn(name = "idatendente")
    private Atendente atendente;

    public ServiceOrder() {
    }

    public ServiceOrder(UUID id, String titleOS, String description, StatusPedido orderStatus,
                        Gerente gerente, Atendente atendente) {
        this.id = id;
        this.titleOS = titleOS;
        this.description = description;
        this.orderStatus = orderStatus;
        this.gerente = gerente;
        this.atendente = atendente;
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

    public String getTitleOS() {
        return titleOS;
    }

    public void setTitleOS(String titleOS) {
        this.titleOS = titleOS;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public StatusPedido getStatusPedido() {
        return orderStatus;
    }

    public void setStatusPedido(StatusPedido orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceOrder that = (ServiceOrder) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

