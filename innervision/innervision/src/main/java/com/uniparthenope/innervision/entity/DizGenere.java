package com.uniparthenope.innervision.entity;

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


}
