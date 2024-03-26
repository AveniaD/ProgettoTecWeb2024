package com.uniparthenope.innervision.entity.diz;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DIZ_STATO_CARRELLO")
@Getter
@Setter
public class DizStatoCarrello {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_STATO_CARRELLO", nullable = false)
    private Long idMarchio;

    @Column(name = "DESC_STATO_CARRELLO", nullable = false)
    private String descStatoCarrello;

    @Column(name = "ATTIVO", nullable = false, length = 1)
    private String attivo;

}
