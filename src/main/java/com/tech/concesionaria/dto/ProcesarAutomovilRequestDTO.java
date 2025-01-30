package com.tech.concesionaria.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProcesarAutomovilRequestDTO {

    @NotNull(message = "El nombre del portico no puede ser null")
    private String nombrePortico;

    @NotNull(message = "La patente no puede ser null")
    private String patente;

    @Min(value = 1, message = "El numero de carril minimo debe ser 1")
    @Max(value = 4, message = "El numero maximo debe ser 4")
    private int carril;

}
