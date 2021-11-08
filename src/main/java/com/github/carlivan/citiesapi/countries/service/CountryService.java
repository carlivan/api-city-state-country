package com.github.carlivan.citiesapi.countries.service;

import com.github.carlivan.citiesapi.countries.Country;
import com.github.carlivan.citiesapi.countries.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    private CountryRepository repository;

    public Page<Country> findAll(Pageable page) {
        return repository.findAll(page);
    }

    public Optional<Country> findById(Long id) {
        return repository.findById(id);
    }
}
