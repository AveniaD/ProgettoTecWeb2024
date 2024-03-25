package com.uniparthenope.innervision.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DIZ_MARCHIO")
@Getter
@Setter
public class DizMarchio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_MARCHIO", nullable = false)
    private Long idMarchio;

}
