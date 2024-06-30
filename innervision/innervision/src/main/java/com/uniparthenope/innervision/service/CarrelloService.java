package com.uniparthenope.innervision.service;

import com.uniparthenope.innervision.common.RequestGestioneCarrello;
import com.uniparthenope.innervision.dto.CarrelloDto;

public interface CarrelloService {
    CarrelloDto addArticolo(RequestGestioneCarrello requestGestioneCarrelloInInput);

    CarrelloDto removeArticolo(RequestGestioneCarrello requestGestioneCarrelloInInput);

    CarrelloDto showCarrello(RequestGestioneCarrello requestGestioneCarrelloInInput);

    CarrelloDto svuotaCarrello(RequestGestioneCarrello requestGestioneCarrelloInInput);

    Boolean cambiaStatoCarrello(RequestGestioneCarrello requestGestioneCarrelloInInput);

    CarrelloDto getCarrelloByUsername(String username);
}
