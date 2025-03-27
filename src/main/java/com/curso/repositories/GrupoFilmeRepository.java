package com.curso.repositories;

import com.curso.domains.GrupoFilme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface GrupoFilmeRepository extends JpaRepository<GrupoFilme,Long>{

    Optional<GrupoFilme> findBynome(String nome);
}
