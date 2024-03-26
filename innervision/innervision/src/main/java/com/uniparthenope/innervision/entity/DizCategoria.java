package com.uniparthenope.innervision.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DIZ_CATEGORIA")
@Getter
@Setter
public class DizCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_CATEGORIA", nullable = false)
    private Long idCategoria;

    @Column(name = "DESC_CATEGORIA", nullable = false)
    private String descCategoria;

    @Column(name = "ATTIVO", nullable = false, length = 1)
    private String attivo;
}
