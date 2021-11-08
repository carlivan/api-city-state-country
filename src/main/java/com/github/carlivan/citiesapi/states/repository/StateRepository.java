package com.github.carlivan.citiesapi.states.repository;

import com.github.carlivan.citiesapi.states.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
