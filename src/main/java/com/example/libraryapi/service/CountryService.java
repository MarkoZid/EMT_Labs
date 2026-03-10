package com.example.libraryapi.service;

import com.example.libraryapi.dto.CountryDto;
import com.example.libraryapi.exception.ResourceNotFoundException;
import com.example.libraryapi.model.Country;
import com.example.libraryapi.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountryById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));
    }

    public Country addCountry(CountryDto dto) {
        Country country = new Country();
        country.setName(dto.getName());
        country.setContinent(dto.getContinent());
        return countryRepository.save(country);
    }
}
