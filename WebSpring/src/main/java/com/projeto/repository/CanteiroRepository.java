package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.Canteiro;
import com.projeto.model.Escopo;

@Repository
public interface CanteiroRepository extends JpaRepository<Canteiro, Long> {

}
