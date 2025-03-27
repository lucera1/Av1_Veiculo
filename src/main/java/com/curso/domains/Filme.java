package com.curso.domains;

import com.curso.domains.dtos.FilmeDTO;
import com.curso.domains.enums.ClassificacaoFilme;
import com.curso.domains.enums.EstadoFilme;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "filme")
public class Filme {


    @ManyToOne
    @JoinColumn(name = "grupo_filme_id")
    private GrupoFilme grupoFilme;

    @JsonManagedReference
    @OneToMany(mappedBy = "filme")
    private List<Sessao> sessoes = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_filme")
    private Long idFilme;

    @Column(unique = true)
    @NotBlank(message = "O título do filme não pode ser vazio")
    private String titulo;

    @NotBlank(message = "O gênero do filme não pode ser vazio")
    private String genero;

    @Positive(message = "A duração do filme deve ser um valor positivo")
    @NotNull(message = "A duração do filme é obrigatória")
    private Integer duracao;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O estado do filme não pode ser nulo")
    private EstadoFilme estadoFilme;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "A classificação do filme não pode ser nula")
    private ClassificacaoFilme classificacaoFilme;


    public Filme() {
    }

    public Filme(Long idFilme, String titulo, String genero, Integer duracao, EstadoFilme estadoFilme, ClassificacaoFilme classificacaoFilme, GrupoFilme grupoFilme) {
        this.idFilme = idFilme;
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.estadoFilme = estadoFilme;
        this.classificacaoFilme = classificacaoFilme;
        this.grupoFilme = grupoFilme;
    }

    public Filme(FilmeDTO dto) {
        this.idFilme = dto.getIdFilme();
        this.titulo = dto.getTitulo();
        this.genero = dto.getGenero();
        this.duracao = dto.getDuracao();
        this.estadoFilme = dto.getEstadoFilme();
        this.classificacaoFilme = dto.getClassificacaoFilme();
        this.grupoFilme = dto.getGrupoFilme();
    }


    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public EstadoFilme getEstadoFilme() {
        return estadoFilme;
    }

    public void setEstadoFilme(EstadoFilme estadoFilme) {
        this.estadoFilme = estadoFilme;
    }

    public ClassificacaoFilme getClassificacaoFilme() {
        return classificacaoFilme;
    }

    public void setClassificacaoFilme(ClassificacaoFilme classificacaoFilme) {
        this.classificacaoFilme = classificacaoFilme;
    }

    public GrupoFilme getGrupoFilme() {
        return grupoFilme;
    }

    public void setGrupoFilme(GrupoFilme grupoFilme) {
        this.grupoFilme = grupoFilme;
    }
}
