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

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

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

    public Utente(Long idUtente, String nome, String cognome, String username, String email, String password, DizTipologiaUtente tipologiaUtente, Carrello carrelloUtente) {
        this.idUtente = idUtente;
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.email = email;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
