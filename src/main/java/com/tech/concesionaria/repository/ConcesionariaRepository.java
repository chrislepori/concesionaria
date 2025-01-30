package com.tech.concesionaria.repository;

import com.tech.concesionaria.domain.Concesionaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConcesionariaRepository extends JpaRepository<Concesionaria, Long> {

    Optional<Concesionaria> findByName(String name);


}
