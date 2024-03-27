package com.uniparthenope.innervision.entity;

import com.uniparthenope.innervision.entity.diz.DizStatoCarrello;
import com.uniparthenope.innervision.entity.diz.DizTipologiaUtente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "CARRELLO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carrello {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_CARRELLO", nullable = false)
    private Long idCarrello;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Articolo> articoli;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_STATO_CARRELLo")
    private DizStatoCarrello statoCarrello;
}
