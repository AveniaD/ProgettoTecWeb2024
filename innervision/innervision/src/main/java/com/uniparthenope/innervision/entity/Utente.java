package com.uniparthenope.innervision.entity;

import com.uniparthenope.innervision.entity.diz.DizTipologiaUtente;
import jakarta.persistence.*;

@Entity
@Table(name = "Utente")
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

    public Utente() {
    }

    public Utente(Long idUtente, String username, String password, DizTipologiaUtente tipologiaUtente, Carrello carrelloUtente) {
        this.idUtente = idUtente;
        this.username = username;
        this.password = password;
        this.tipologiaUtente = tipologiaUtente;
        this.carrelloUtente = carrelloUtente;
    }

    public Long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Long idUtente) {
        this.idUtente = idUtente;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DizTipologiaUtente getTipologiaUtente() {
        return tipologiaUtente;
    }

    public void setTipologiaUtente(DizTipologiaUtente tipologiaUtente) {
        this.tipologiaUtente = tipologiaUtente;
    }

    public Carrello getCarrelloUtente() {
        return carrelloUtente;
    }

    public void setCarrelloUtente(Carrello carrelloUtente) {
        this.carrelloUtente = carrelloUtente;
    }
}
