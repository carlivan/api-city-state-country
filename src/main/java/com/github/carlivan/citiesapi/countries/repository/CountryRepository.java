package com.github.carlivan.citiesapi.countries.repository;

import com.github.carlivan.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
