package com.uniparthenope.innervision.entity.diz;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DIZ_TIPOLOGIA_UTENTE")
@Getter
@Setter
public class DizTipologiaUtente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_TIPOLOGIA_UTENTE", nullable = false)
    private Long idTipologiaUtente;

    @Column(name = "DESC_TIPOLOGIA_UTENTE", nullable = false)
    private String descTipologiaUtente;

    @Column(name = "ATTIVO", nullable = false, length = 1)
    private String attivo;

}
