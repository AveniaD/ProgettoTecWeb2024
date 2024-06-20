package com.uniparthenope.innervision.controller;

import static com.uniparthenope.innervision.common.DefaultStrings.*;

import com.uniparthenope.innervision.dto.UtenteDto;
import com.uniparthenope.innervision.dto.diz.DizCategoriaDto;
import com.uniparthenope.innervision.entity.Utente;
import com.uniparthenope.innervision.service.UtenteService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class GestioneUtenteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GestioneUtenteController.class);

    @Autowired
    private UtenteService utenteService;

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Effettua la registrazione di un utente",
            notes = "Restituisce l'utente registrato.",
            response = UtenteDto.class)
    public ResponseEntity<Map<String, Object>> registerUser(@RequestBody Utente utenteInInput) {
        try {
            LOGGER.info("Chiamata REST /getDizCategoria");

            Long idUtenteRegistrato = utenteService.registrazione(utenteInInput);

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, idUtenteRegistrato);
            result.put(MESSAGGIO, "Lista delle categorie disponibili");
            result.put(OPERAZIONE, "Info dati categoria");

            LOGGER.info("Fine chiamata Rest /getDizCategoria");

            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            LOGGER.error(MESSAGGIO_ERORE, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGGIO_ERORE, e);
            // Da gestire diversamente in questo caso
            // return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //Login
}
