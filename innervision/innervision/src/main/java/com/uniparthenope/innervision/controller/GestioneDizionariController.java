package com.uniparthenope.innervision.controller;

import com.uniparthenope.innervision.service.diz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dizionari")
public class GestioneDizionariController {

    @Autowired
    DizCategoriaService dizCategoriaService;

    @Autowired
    DizColoreService dizColoreService;

    @Autowired
    DizGenereService dizGenereService;

    @Autowired
    DizMarchioService dizMarchioService;

    @Autowired
    DizStatoCarrelloService dizStatoCarrelloService;

    @Autowired
    DizTipologiaUtenteService dizTipologiaUtenteService;


    //Varie request GET dei vari dizionari
}
