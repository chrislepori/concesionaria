package com.tech.concesionaria.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "porticos")
public class Portico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)//esto permite que al crear un portico se creen en bd los sensores
    @JoinColumn(name = "portico_id")
    private List<Sensor> sensores;

    public Sensor buscarSensorPorCarril(int numeroCarril) {
        return sensores.stream()
                .filter(s -> s.getNumero() == numeroCarril)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No se encontró un sensor para el carril especificado"));
    }


}
