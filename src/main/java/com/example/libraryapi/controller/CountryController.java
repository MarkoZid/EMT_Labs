package com.example.libraryapi.controller;

import com.example.libraryapi.dto.CountryDto;
import com.example.libraryapi.model.Country;
import com.example.libraryapi.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable Long id) {
        return countryService.getCountryById(id);
    }

    @PostMapping
    public ResponseEntity<Country> addCountry(@Valid @RequestBody CountryDto dto) {
        Country country = countryService.addCountry(dto);
        return ResponseEntity.ok(country);
    }
}
