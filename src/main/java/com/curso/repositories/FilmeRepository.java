package com.curso.repositories;


import com.curso.domains.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmeRepository extends JpaRepository<Filme,Long> {

    Optional<Filme> findBytitulo(String titulo);

}