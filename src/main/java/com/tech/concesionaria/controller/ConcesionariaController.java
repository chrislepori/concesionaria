package com.tech.concesionaria.controller;

import com.tech.concesionaria.domain.Concesionaria;
import com.tech.concesionaria.dto.CreateConcesionariaRequestDTO;
import com.tech.concesionaria.dto.ProcesarAutomovilRequestDTO;
import com.tech.concesionaria.service.ConcesionariaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/concesionaria")
public class ConcesionariaController {

    private final ConcesionariaService concesionariaService;

    @PostMapping("/create")
    public ResponseEntity<Void> createConcesionaria(@RequestBody @Valid CreateConcesionariaRequestDTO createConcesionariaRequestDTO){
        concesionariaService.createConcesionaria(createConcesionariaRequestDTO.getName());
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PostMapping
    public ResponseEntity<Float> procesar(@RequestBody @Valid ProcesarAutomovilRequestDTO procesarAutomovilRequestDTO){
        return ResponseEntity.ok().body(concesionariaService.procesar(procesarAutomovilRequestDTO));

    }
}
