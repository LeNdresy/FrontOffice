package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "historique")
public class Historique {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idhistorique;

    @Column(name = "idenchere")
    Long idenchere;

    @Column(name = "idclient")
    Long idclient;

    @Column(name = "prix")
    double prix;

}
