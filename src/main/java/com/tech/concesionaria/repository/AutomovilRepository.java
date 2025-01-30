package com.tech.concesionaria.repository;

import com.tech.concesionaria.domain.Automovil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutomovilRepository extends JpaRepository<Automovil, Long> {

    Optional<Automovil> findByPatente(String patente);

    Automovil findFirstByOrderByPesoDesc();

    /*
    esto hace el OrderByPesoDesc:
    SELECT *
    FROM automovil
    ORDER BY peso DESC
    LIMIT 1;
    esto hace el findFirst:
    encuentra el primer elemento de la lista ordenado por peso
     */

}
