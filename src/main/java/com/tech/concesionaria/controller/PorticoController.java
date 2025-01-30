package com.tech.concesionaria.controller;

import com.tech.concesionaria.domain.Portico;
import com.tech.concesionaria.dto.CretePorticoRequestDTO;
import com.tech.concesionaria.service.PorticoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/porticos")
@AllArgsConstructor
public class PorticoController {

    private PorticoService porticoService;

    @PostMapping
    public ResponseEntity<Portico> crearPortico(@RequestBody @Valid CretePorticoRequestDTO porticoRequestDTO){
        return ResponseEntity.ok().body(porticoService.crearPortico(porticoRequestDTO.getNombre()));
    }

}
