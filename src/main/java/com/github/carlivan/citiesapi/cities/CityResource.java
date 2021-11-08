package com.github.carlivan.citiesapi.cities;

import com.github.carlivan.citiesapi.cities.repository.CityRepository;
import com.github.carlivan.citiesapi.cities.service.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cities")
public class CityResource {
    private CityService service;

    public CityResource(CityService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<City>> cities(Pageable pageable){
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getOne(@PathVariable Long id){
        City city = service.getOne(id);
        if (city == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(city);
    }
}
