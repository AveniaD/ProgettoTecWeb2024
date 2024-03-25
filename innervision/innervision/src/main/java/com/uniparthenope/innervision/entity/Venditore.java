package com.uniparthenope.innervision.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "VENDITORE")
public class Venditore {

    @Id
    @Column(name = "ID_VENDITORE", unique = true, nullable = false)
    private Long idVenditore;
}
