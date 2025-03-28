package com.curso.repositories;

import com.curso.domains.Atendente;
import com.curso.domains.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long>{
    Optional<Gerente> findByCpf(String cpf);
    Optional<Gerente> findByEmail(String email);
}
