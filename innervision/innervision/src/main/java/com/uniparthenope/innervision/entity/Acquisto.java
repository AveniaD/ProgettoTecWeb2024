package com.uniparthenope.innervision.entity;

public class Acquisto {
    private int idUtente;
    private int idArticolo;
    private String marchio;

    public Acquisto(int idUtente, int idArticolo, String marchio) {
        this.idUtente = idUtente;
        this.idArticolo = idArticolo;
        this.marchio = marchio;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public int getIdArticolo() {
        return idArticolo;
    }

    public String getMarchio() {
        return marchio;
    }
}
