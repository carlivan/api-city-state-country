package com.github.carlivan.citiesapi.states.service;

import com.github.carlivan.citiesapi.states.State;
import com.github.carlivan.citiesapi.states.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    @Autowired
    private StateRepository repository;


    public List<State> findAll() {
        return repository.findAll();
    }

    public State getOne(Long id){
        Optional<State> optional = repository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }
}
