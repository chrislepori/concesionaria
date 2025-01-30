package com.tech.concesionaria.service;

import com.tech.concesionaria.domain.Sensor;
import com.tech.concesionaria.exception.ApiException;
import com.tech.concesionaria.exception.Error;
import com.tech.concesionaria.repository.AutomovilRepository;
import com.tech.concesionaria.repository.SensorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.tech.concesionaria.exception.Error.SENSOR_NOT_FOUND;

@Service
@AllArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;
    private final AutomovilRepository automovilRepository;


    public Sensor updateSensor(Sensor s) {
        return sensorRepository.save(s);
    }

    public void eliminarSensor(int numero) {
        Sensor s = sensorRepository.findByNumero(numero)
                .orElseThrow(() -> new ApiException(SENSOR_NOT_FOUND));
        sensorRepository.delete(s);
    }


}
