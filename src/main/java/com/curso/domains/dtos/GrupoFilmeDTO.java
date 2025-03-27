package com.curso.domains.dtos;

import com.curso.domains.GrupoFilme;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class GrupoFilmeDTO {

    private Long idGrupoFilme;

    @NotBlank(message = "O nome do grupo de filme não pode ser vazio")
    private String nome;

    public GrupoFilmeDTO (){
    }

    public GrupoFilmeDTO(GrupoFilme grupoFilme) {
        this.idGrupoFilme = grupoFilme.getIdGrupoFilme();
        this.nome = grupoFilme.getNome();
    }

    public @NotNull(message = "O ID do grupo de filme não pode ser nulo") Long getIdGrupoFilme() {
        return idGrupoFilme;
    }

    public void setIdGrupoFilme(@NotNull(message = "O ID do grupo de filme não pode ser nulo") Long idGrupoFilme) {
        this.idGrupoFilme = idGrupoFilme;
    }

    public @NotBlank(message = "O nome do grupo de filme não pode ser vazio") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome do grupo de filme não pode ser vazio") String nome) {
        this.nome = nome;
    }
}
