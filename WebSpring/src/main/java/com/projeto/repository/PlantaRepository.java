package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.Planta;

@Repository
public interface PlantaRepository extends JpaRepository<Planta, Long> {

}
