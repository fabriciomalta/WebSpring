package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.Plantio;

@Repository
public interface PlantioRepository extends JpaRepository<Plantio, Long> {

}
