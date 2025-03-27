package com.curso.domains.dtos;

import com.curso.domains.Filme;
import com.curso.domains.GrupoFilme;
import com.curso.domains.enums.ClassificacaoFilme;
import com.curso.domains.enums.EstadoFilme;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class FilmeDTO {

    private Long idFilme;

    @NotBlank(message = "O título do filme não pode ser vazio")
    private String titulo;

    @NotBlank(message = "O gênero do filme não pode ser vazio")
    private String genero;

    @Positive(message = "A duração do filme deve ser um valor positivo")
    @NotNull(message = "A duração do filme é obrigatória")
    private int duracao;

    @NotNull(message = "O estado do filme não pode ser nulo")
    private EstadoFilme estadoFilme;

    @NotNull(message = "A classificação do filme não pode ser nula")
    private ClassificacaoFilme classificacaoFilme;

    @NotNull(message = "O grupo de filme não pode ser nulo")
    private GrupoFilme grupoFilme;

    public FilmeDTO(){
    }


    public FilmeDTO(Filme filme) {
        this.idFilme = filme.getIdFilme();
        this.titulo = filme.getTitulo();
        this.genero = filme.getGenero();
        this.duracao = filme.getDuracao();
        this.estadoFilme = filme.getEstadoFilme();
        this.classificacaoFilme = filme.getClassificacaoFilme();
        this.grupoFilme = filme.getGrupoFilme();
    }

    public @NotNull(message = "O ID do filme não pode ser nulo") Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(@NotNull(message = "O ID do filme não pode ser nulo") Long idFilme) {
        this.idFilme = idFilme;
    }

    public @NotBlank(message = "O título do filme não pode ser vazio") String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotBlank(message = "O título do filme não pode ser vazio") String titulo) {
        this.titulo = titulo;
    }

    public @NotBlank(message = "O gênero do filme não pode ser vazio") String getGenero() {
        return genero;
    }

    public void setGenero(@NotBlank(message = "O gênero do filme não pode ser vazio") String genero) {
        this.genero = genero;
    }

    @Positive(message = "A duração do filme deve ser um valor positivo")
    @NotNull(message = "A duração do filme é obrigatória")
    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(@Positive(message = "A duração do filme deve ser um valor positivo") @NotNull(message = "A duração do filme é obrigatória") int duracao) {
        this.duracao = duracao;
    }

    public @NotNull(message = "O estado do filme não pode ser nulo") EstadoFilme getEstadoFilme() {
        return estadoFilme;
    }

    public void setEstadoFilme(@NotNull(message = "O estado do filme não pode ser nulo") EstadoFilme estadoFilme) {
        this.estadoFilme = estadoFilme;
    }

    public @NotNull(message = "A classificação do filme não pode ser nula") ClassificacaoFilme getClassificacaoFilme() {
        return classificacaoFilme;
    }

    public void setClassificacaoFilme(@NotNull(message = "A classificação do filme não pode ser nula") ClassificacaoFilme classificacaoFilme) {
        this.classificacaoFilme = classificacaoFilme;
    }

    public @NotNull(message = "O grupo de filme não pode ser nulo") GrupoFilme getGrupoFilme() {
        return grupoFilme;
    }

    public void setGrupoFilme(@NotNull(message = "O grupo de filme não pode ser nulo") GrupoFilme grupoFilme) {
        this.grupoFilme = grupoFilme;
    }
}


