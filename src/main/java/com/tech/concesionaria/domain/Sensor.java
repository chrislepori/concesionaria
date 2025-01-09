package com.tech.concesionaria.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "sensores")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    @JoinColumn(name = "sensor_id") //en la tabla Automoviles será la clave foránea que referencia la clave primaria de la tabla Sensores.
    private List<Automovil> automoviles;

    public float procesarVehiculoRetornarImporte(Automovil a) {
            automoviles.add(a);
            float costo = (float) a.calcularPrecio();
            return costo;

    }

}
