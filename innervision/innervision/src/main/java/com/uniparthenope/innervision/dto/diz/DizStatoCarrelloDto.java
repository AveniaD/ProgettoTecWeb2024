package com.uniparthenope.innervision.dto.diz;

import lombok.Getter;
import lombok.Setter;

public class DizStatoCarrelloDto {

    private Long idMarchio;

    private String descStatoCarrello;

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
