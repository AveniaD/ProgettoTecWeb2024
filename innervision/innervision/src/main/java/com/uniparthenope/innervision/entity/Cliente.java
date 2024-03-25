package com.uniparthenope.innervision.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @Column(name = "ID_CLIENTE", unique = true, nullable = false)
    private Long idCliente;
}
