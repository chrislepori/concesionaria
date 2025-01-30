package com.tech.concesionaria.service;

import com.tech.concesionaria.domain.Automovil;
import com.tech.concesionaria.domain.Portico;
import com.tech.concesionaria.domain.Sensor;
import com.tech.concesionaria.exception.ApiException;
import com.tech.concesionaria.exception.Error;
import com.tech.concesionaria.repository.PorticoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PorticoService {

    private final PorticoRepository porticoRepository;
    private final SensorService sensorService;

    public Portico findByNombre(String nombre) {
        return porticoRepository.findByNombre(nombre)
                .orElseThrow(() -> new ApiException(Error.PORTICO_NOT_FOUND));
    }

    public Portico crearPortico(String nombre) {
        Optional<Portico> portico = porticoRepository.findByNombre(nombre);
        List<Sensor> sensores = new ArrayList<>();
        if (portico.isPresent()) {
            throw new ApiException(Error.PORTICO_YA_EXISTENTE);
        }
        generarSensores(sensores);
        Portico p = Portico.builder()
                .nombre(nombre)
                .sensores(sensores)
                .build();


        return porticoRepository.save(p);
    }

    private void generarSensores(List<Sensor> sensores) {
        for (int i = 0; i < 4; i++) {
            Sensor sensor = new Sensor(i + 1);
            sensores.add(sensor);
        }
    }

    public float procesarVehiculo(Portico portico, Automovil a, Sensor sensor) {
        float costo = sensor.procesarVehiculoRetornarImporte(a);
        sensorService.updateSensor(sensor);

        return costo;
    }
}
