package com.tech.concesionaria.service;

import com.tech.concesionaria.domain.Automovil;
import com.tech.concesionaria.domain.Sensor;
import com.tech.concesionaria.repository.SensorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;


    public void createSensor(Sensor s){
        sensorRepository.save(s);
    }

    public void eliminarSensor(Long id){
        Sensor s = sensorRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("No se encontró el sensor"));
        sensorRepository.delete(s);
    }

    public float agregarAutomovil(Long sensorId, Automovil automovil) {
        Sensor sensor = sensorRepository.findById(sensorId)
                .orElseThrow(() -> new IllegalArgumentException("Sensor no encontrado"));

        float costo = sensor.procesarVehiculoRetornarImporte(automovil);

        // Actualizar el sensor en la base de datos
        sensorRepository.save(sensor); // Esto asegura que se persista el nuevo automóvil

        return costo;
    }
}
