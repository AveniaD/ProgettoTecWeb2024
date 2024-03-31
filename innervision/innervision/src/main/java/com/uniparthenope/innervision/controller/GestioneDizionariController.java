package com.uniparthenope.innervision.controller;

import com.uniparthenope.innervision.service.diz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dizionari")
public class GestioneDizionariController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GestioneDizionariController.class);

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

    @GetMapping("/getDizCategoria")
    public ResponseEntity<Map<String, Object>> getDizCategoria(){

        LOGGER.info("/getDizCategoria");

        Map<String, Object> result = new HashMap<>();

        result.put("Dto",dizCategoriaService.findAllByAttivo());
        result.put("Messaggio", "Lista delle categorie disponibili");
        result.put("Operazione", "Info dati categoria");

        return ResponseEntity.ok().body(result);
    }

}
