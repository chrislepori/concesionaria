package com.tech.concesionaria.service;

import com.tech.concesionaria.domain.Automovil;
import com.tech.concesionaria.domain.Concesionaria;
import com.tech.concesionaria.domain.Portico;
import com.tech.concesionaria.domain.Sensor;
import com.tech.concesionaria.dto.ProcesarAutomovilRequestDTO;
import com.tech.concesionaria.exception.ApiException;
import com.tech.concesionaria.exception.Error;
import com.tech.concesionaria.repository.ConcesionariaRepository;
import com.tech.concesionaria.repository.PorticoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.tech.concesionaria.exception.Error.CONCESIONARIA_YA_EXISTENTE;

@AllArgsConstructor
@Service
public class ConcesionariaService {

    private final ConcesionariaRepository concesionariaRepository;
    private final PorticoService porticoService;
    private final AutomovilService automovilService;

    public void createConcesionaria(String name) {
        Optional<Concesionaria> cons = concesionariaRepository.findByName(name);
        if (cons.isPresent()) {
            throw new ApiException(CONCESIONARIA_YA_EXISTENTE);
        }
        Concesionaria concesionaria = Concesionaria.builder()
                .name(name)
                .build();
        concesionariaRepository.save(concesionaria);


    }


    public float procesar(ProcesarAutomovilRequestDTO procesarAutomovilRequestDTO) {
        Automovil automovil = automovilService.findByPatente(procesarAutomovilRequestDTO.getPatente());
        Portico portico = porticoService.findByNombre(procesarAutomovilRequestDTO.getNombrePortico());
        Sensor sensor = portico.buscarSensorPorCarril(procesarAutomovilRequestDTO.getCarril());

        return porticoService.procesarVehiculo(portico, automovil, sensor);
    }

}
