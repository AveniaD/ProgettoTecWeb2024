package com.uniparthenope.innervision.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "VENDITORE")
@Getter
@Setter
public class Venditore {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_VENDITORE", unique = true, nullable = false)
    private Long idVenditore;
}
