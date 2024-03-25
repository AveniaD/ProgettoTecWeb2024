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
}
