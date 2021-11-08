package com.github.carlivan.citiesapi.cities.service;

import com.github.carlivan.citiesapi.cities.City;
import com.github.carlivan.citiesapi.cities.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository repository;

    public Page<City> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public City getOne(Long id) {
        Optional<City> optional = repository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }
}
