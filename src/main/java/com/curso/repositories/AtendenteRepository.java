package com.curso.repositories;

import com.curso.domains.Atendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente, Long> {
    Optional<Atendente> findByCpf(String cpf);
    Optional<Atendente> findByEmail(String email);

}
