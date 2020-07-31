package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.Colhido;
import com.projeto.model.Escopo;

@Repository
public interface ColhidoRepository extends JpaRepository<Colhido, Long>{

}
