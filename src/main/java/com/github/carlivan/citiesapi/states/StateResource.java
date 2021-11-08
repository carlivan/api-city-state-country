package com.github.carlivan.citiesapi.states;

import com.github.carlivan.citiesapi.states.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateResource {
    @Autowired
    private StateService service;

    @GetMapping
    public ResponseEntity<List<State>> states(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> getOne(@PathVariable Long id){
        State state = service.getOne(id);
        if(state == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(state);
    }

}
