package com.uniparthenope.innervision.entity.diz;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DIZ_GENERE")
@Getter
@Setter
public class DizGenere {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_GENERE", nullable = false)
    private Long idGenere;

    @Column(name = "DESC_GENERE", nullable = false)
    private String descGenere;

    @Column(name = "ATTIVO", nullable = false, length = 1)
    private String attivo;
}
