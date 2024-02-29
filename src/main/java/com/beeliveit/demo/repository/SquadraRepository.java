package com.beeliveit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beeliveit.demo.model.Squadra;
import java.util.List;


@Repository
public interface SquadraRepository extends JpaRepository<Squadra, Integer>{
    
List<Squadra> findById(int id);
List<Squadra> findByNome(String nome);
List<Squadra> findByCitta(String citta);
List<Squadra> findByPunteggio(Integer punteggio);



}
