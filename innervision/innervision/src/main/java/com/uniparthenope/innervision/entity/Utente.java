package com.uniparthenope.innervision.entity;

import com.uniparthenope.innervision.entity.diz.DizTipologiaUtente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Utente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_UTENTE", nullable = false)
    private Long idUtente;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_TIPOLOGIA_UTENTE")
    private DizTipologiaUtente tipologiaUtente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CARRELLO")
    private Carrello carrelloUtente;
}
