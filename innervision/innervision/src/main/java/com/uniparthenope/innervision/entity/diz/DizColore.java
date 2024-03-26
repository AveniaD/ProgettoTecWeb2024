package com.uniparthenope.innervision.entity.diz;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DIZ_COLORE")
@Getter
@Setter
public class DizColore {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_COLORE", nullable = false)
    private Long idColore;

    @Column(name = "DESC_COLORE", nullable = false)
    private String descColore;

    @Column(name = "ATTIVO", nullable = false, length = 1)
    private String attivo;
}
