package com.github.carlivan.citiesapi.countries;

import com.github.carlivan.citiesapi.countries.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {
    @Autowired
    private CountryService service;

    @GetMapping
    public Page<Country> countries(Pageable page){
        return service.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Optional<Country> optional = service.findById(id);

        if(optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
        }
        return ResponseEntity.notFound().build();
    }
}
