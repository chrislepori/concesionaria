package com.tech.concesionaria.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class CretePorticoRequestDTO {

    @NotNull(message = "El nombre no puede ser null")
    private String nombre;
}
