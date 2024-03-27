package com.uniparthenope.innervision.entity;

import com.uniparthenope.innervision.entity.diz.DizStatoCarrello;
import com.uniparthenope.innervision.entity.diz.DizTipologiaUtente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "CARRELLO")
@Getter
@Setter
public class Carrello {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_CARRELLO", nullable = false)
    private Long idCarrello;

    //Da verificare il mappedBy
    @OneToMany(cascade = CascadeType.ALL)
    private List<Articolo> articoli;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_STATO_CARRELLo")
    private DizStatoCarrello statoCarrello;
}
