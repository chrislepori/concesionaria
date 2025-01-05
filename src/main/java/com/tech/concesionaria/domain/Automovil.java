package com.tech.concesionaria.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.naming.Name;

@Entity
@AllArgsConstructor
@Data
@Table(name = "automoviles")
public class Automovil {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true) //ESTO ES PARA BASE DE DATOS
    private String patente;
    private int peso;

}
