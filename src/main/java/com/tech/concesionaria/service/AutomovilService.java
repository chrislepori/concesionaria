package com.tech.concesionaria.service;

import com.tech.concesionaria.domain.Automovil;
import com.tech.concesionaria.exception.ApiException;
import com.tech.concesionaria.repository.AutomovilRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.tech.concesionaria.exception.Error.AUTOMOVIL_NOT_FOUND;
import static com.tech.concesionaria.exception.Error.AUTOMOVIL_YA_EXISTE;


@Service
@AllArgsConstructor
public class AutomovilService {

    private final AutomovilRepository automovilRepository;

    public Automovil findByPatente(String patente){
        return automovilRepository.findByPatente(patente)
                .orElseThrow(() -> new ApiException(AUTOMOVIL_NOT_FOUND));
    }

    public void createAutomovil(Automovil automovil){
        Optional<Automovil> auto = automovilRepository.findByPatente(automovil.getPatente());//optional es un rapper ayuda a no caer el null pointer y evital el nul
        if(auto.isPresent()){
            throw new ApiException(AUTOMOVIL_YA_EXISTE);
        }
        automovilRepository.save(automovil);
    }

    public void eliminarAutomovil(String patente){
        Automovil auto = automovilRepository.findByPatente(patente)
                .orElseThrow(()-> new ApiException(AUTOMOVIL_NOT_FOUND)); //igual a create, usa el Optional pero de otro modo. Usa lamda
        automovilRepository.delete(auto);

    }

    public Automovil heaviestCar(){
        Automovil a = automovilRepository.findFirstByOrderByPesoDesc();
        System.out.println("El auto más pesado pesa: " + a.getPeso() + " y su patente es: " + a.getPatente());
        return a;
    }




}
