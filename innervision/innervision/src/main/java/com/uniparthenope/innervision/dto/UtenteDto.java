package com.uniparthenope.innervision.dto;

import com.uniparthenope.innervision.entity.Carrello;
import com.uniparthenope.innervision.entity.diz.DizTipologiaUtente;

public class UtenteDto {

    private Long idUtente;

    private String username;

    private String password;

    private DizTipologiaUtente tipologiaUtente;

    private Carrello carrelloUtente;

    public UtenteDto() {
    }

    public UtenteDto(Long idUtente, String username, String password, DizTipologiaUtente tipologiaUtente, Carrello carrelloUtente) {
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
