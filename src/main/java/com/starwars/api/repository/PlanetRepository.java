package com.starwars.api.repository;

import com.starwars.api.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {
    Optional<Planet> findByName(String name);
}
