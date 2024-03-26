package com.uniparthenope.innervision.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Utente")
@Getter
@Setter
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_UTENTE", unique = true, nullable = false)
    private Long idUtente;

}
