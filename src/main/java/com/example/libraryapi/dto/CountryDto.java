package com.example.libraryapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryDto {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Continent is required")
    private String continent;
}
