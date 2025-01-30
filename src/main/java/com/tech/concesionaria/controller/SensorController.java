package com.tech.concesionaria.controller;

import com.tech.concesionaria.domain.Automovil;
import com.tech.concesionaria.domain.Sensor;
import com.tech.concesionaria.service.SensorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/sensores")
public class SensorController {

    private final SensorService sensorService;

    @PostMapping
    public ResponseEntity<Void> createSensor(@RequestBody Sensor s){
        sensorService.updateSensor(s);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @DeleteMapping("/{numero}")
    public ResponseEntity<Void> eliminarSensor(@PathVariable int numero){
        sensorService.eliminarSensor(numero);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
