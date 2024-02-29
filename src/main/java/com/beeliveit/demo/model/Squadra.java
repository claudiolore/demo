package com.beeliveit.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Squadra implements Comparable<Squadra>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 60)
    String nome;

    @Column(nullable = false, length = 60)
    String citta;
    
    @Column(nullable = false, length = 60)
    Integer punteggio;

    public Squadra() {
    }

    public Squadra(String nome, String citta, Integer punteggio) {
        this.nome = nome;
        this.citta = citta;
        
        if (punteggio >= 25 && punteggio <= 50) {
            this.punteggio = punteggio;
        } else {
            throw new IllegalArgumentException("Il punteggio deve essere compreso tra 25 e 50");
        }
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public Integer getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(Integer punteggio) {
        this.punteggio = punteggio;
    }

    @Override
    public String toString() {
        return "Squadra [id=" + id + ", nome=" + nome + ", citta=" + citta + ", punteggio=" + punteggio + "]";
    }

    @Override
    public int compareTo(Squadra s) {
        if (this.punteggio>s.punteggio) {
            return 1;
        }else if (this.punteggio<s.punteggio) {
            return -1;
        }else{
            return 0;
        }
    }
    
}
