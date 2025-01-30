package com.tech.concesionaria.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum Error {

    AUTOMOVIL_YA_EXISTE("Ya existe un auto con esa patente", HttpStatus.BAD_REQUEST),
    AUTOMOVIL_NOT_FOUND("No se encontro el automovil", HttpStatus.NOT_FOUND),
    CONCESIONARIA_YA_EXISTENTE("La concesionaria ya existe", HttpStatus.BAD_REQUEST),
    PORTICO_YA_EXISTENTE("El portico ya existe", HttpStatus.BAD_REQUEST),
    PORTICO_NOT_FOUND("Portico no encontrado", HttpStatus.NOT_FOUND),
    SENSOR_NOT_FOUND("No se encontró el sensor", HttpStatus.NOT_FOUND );




    private final String message;
    private final HttpStatus code;

}
