package com.tech.concesionaria.controller;


import com.tech.concesionaria.domain.Automovil;
import com.tech.concesionaria.service.AutomovilService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/automovil")
public class AutomovilController {

    private final AutomovilService automovilService;


    @PostMapping
    public ResponseEntity<Void> createAutomovil(@RequestBody Automovil automovil){
        automovilService.createAutomovil(automovil);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{patente}")
    public ResponseEntity<Void> eliminarAutomovil(@PathVariable String patente){
        automovilService.eliminarAutomovil(patente);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/masPesado")
    public ResponseEntity<Automovil> heaviestCar() {
        return ResponseEntity.ok().body(automovilService.heaviestCar()); //aca se puede usar body porque espera un Automovil
    }

}
