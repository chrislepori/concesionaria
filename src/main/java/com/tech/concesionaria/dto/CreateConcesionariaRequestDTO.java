package com.tech.concesionaria.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateConcesionariaRequestDTO {

    @NotNull(message = "El nombre no puede ser null")
    private String name;

}
