package com.example.libraryapi.service;

import com.example.libraryapi.dto.AuthorDto;
import com.example.libraryapi.exception.ResourceNotFoundException;
import com.example.libraryapi.model.Author;
import com.example.libraryapi.model.Country;
import com.example.libraryapi.repository.AuthorRepository;
import com.example.libraryapi.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorService(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
    }

    public Author addAuthor(AuthorDto dto) {
        Country country = countryRepository.findById(dto.getCountryId())
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + dto.getCountryId()));

        Author author = new Author();
        author.setName(dto.getName());
        author.setSurname(dto.getSurname());
        author.setCountry(country);
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, AuthorDto dto) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));

        Country country = countryRepository.findById(dto.getCountryId())
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + dto.getCountryId()));

        author.setName(dto.getName());
        author.setSurname(dto.getSurname());
        author.setCountry(country);
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Author not found with id: " + id);
        }
        authorRepository.deleteById(id);
    }
}
