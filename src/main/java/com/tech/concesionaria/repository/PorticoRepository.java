package com.tech.concesionaria.repository;

import com.tech.concesionaria.domain.Portico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PorticoRepository extends JpaRepository<Portico, Long> {
    Optional<Portico> findByNombre(String nombre);

}
