package com.tech.concesionaria.service;

import com.tech.concesionaria.domain.Automovil;
import com.tech.concesionaria.repository.AutomovilRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AutomovilService {

    private final AutomovilRepository automovilRepository;

    public Automovil findByPatente(String patente){
        return automovilRepository.findByPatente(patente);
    }

    public void createAutomovil(Automovil automovil){
        Automovil auto = findByPatente(automovil.getPatente());
        if(auto != null){
            throw new IllegalArgumentException("El auto ya existe");
        }
        automovilRepository.save(automovil);
    }

    public void eliminarAutomovil(String patente){
        Automovil auto = findByPatente(patente);
        if(auto != null){
            automovilRepository.delete(auto);
        }
        throw new IllegalArgumentException("No se encontró el automovil");

    }

    public Automovil heaviestCar(){
        Automovil a = automovilRepository.findFirstByOrderByPesoDesc();
        System.out.println("El auto más pesado pesa: " + a.getPeso() + " y su patente es: " + a.getPatente());
        return a;
    }




}
