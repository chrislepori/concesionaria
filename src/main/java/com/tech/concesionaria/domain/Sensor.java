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
    private int numero;
    @OneToMany
    @JoinColumn(name = "sensor_id") //en la tabla Automoviles será la clave foránea que referencia la clave primaria de la tabla Sensores.
    private List<Automovil> automoviles;

    public Sensor(int numero){
        this.numero = numero;
    }

    public float procesarVehiculoRetornarImporte(Automovil automovil) {
        agregarAutomovil(automovil);

        return (float) automovil.calcularPrecio();
    }

    private void agregarAutomovil(Automovil automovil) {
        this.automoviles.add(automovil);
    }


}
