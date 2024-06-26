package com.uniparthenope.innervision.service;

import com.uniparthenope.innervision.common.RequestGestioneCarrello;
import com.uniparthenope.innervision.dto.CarrelloDto;

public interface CarrelloService {
    Boolean addArticolo(RequestGestioneCarrello requestGestioneCarrelloInInput);

    Boolean removeArticolo(RequestGestioneCarrello requestGestioneCarrelloInInput);

    CarrelloDto showCarrello(RequestGestioneCarrello requestGestioneCarrelloInInput);

    Boolean svuotaCarrello(RequestGestioneCarrello requestGestioneCarrelloInInput);

    Boolean cambiaStatoCarrello(RequestGestioneCarrello requestGestioneCarrelloInInput);
}
