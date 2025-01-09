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
        sensorService.createSensor(s);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSensor(@PathVariable Long id){
        sensorService.eliminarSensor(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Float> agregarAutomovil(@PathVariable Long id, @RequestBody Automovil automovil) {
        float costo = sensorService.agregarAutomovil(id, automovil);
        return ResponseEntity.ok(costo); // Devuelve el costo calculado del automóvil
    }
}
