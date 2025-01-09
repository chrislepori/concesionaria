package com.tech.concesionaria.service;

import com.tech.concesionaria.domain.Automovil;
import com.tech.concesionaria.repository.AutomovilRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class AutomovilService {

    private final AutomovilRepository automovilRepository;

    private Optional<Automovil> findByPatente(String patente){
        return automovilRepository.findByPatente(patente);
    }

    public void createAutomovil(Automovil automovil){
        Optional<Automovil> auto = findByPatente(automovil.getPatente());//optional es un rapper ayuda a no caer el null pointer y evital el nul
        if(auto.isPresent()){
            throw new IllegalArgumentException("El auto ya existe");
        }
        automovilRepository.save(automovil);
    }

    public void eliminarAutomovil(String patente){
        Automovil auto = findByPatente(patente)
                .orElseThrow(()-> new IllegalArgumentException("No se encontró el automovil")); //igual a create, usa el Optional pero de otro modo. Usa lamda
        automovilRepository.delete(auto);

    }

    public Automovil heaviestCar(){
        Automovil a = automovilRepository.findFirstByOrderByPesoDesc();
        System.out.println("El auto más pesado pesa: " + a.getPeso() + " y su patente es: " + a.getPatente());
        return a;
    }




}
