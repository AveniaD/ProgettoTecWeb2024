package com.uniparthenope.innervision.entity.diz;

import jakarta.persistence.*;

@Entity
@Table(name = "DIZ_STATO_CARRELLO")
public class DizStatoCarrello {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_STATO_CARRELLO", nullable = false)
    private Long idMarchio;

    @Column(name = "DESC_STATO_CARRELLO", nullable = false)
    private String descStatoCarrello;

    @Column(name = "ATTIVO", nullable = false, length = 1)
    private String attivo;

    public Long getIdMarchio() {
        return idMarchio;
    }

    public void setIdMarchio(Long idMarchio) {
        this.idMarchio = idMarchio;
    }

    public String getDescStatoCarrello() {
        return descStatoCarrello;
    }

    public void setDescStatoCarrello(String descStatoCarrello) {
        this.descStatoCarrello = descStatoCarrello;
    }

    public String getAttivo() {
        return attivo;
    }

    public void setAttivo(String attivo) {
        this.attivo = attivo;
    }
}
