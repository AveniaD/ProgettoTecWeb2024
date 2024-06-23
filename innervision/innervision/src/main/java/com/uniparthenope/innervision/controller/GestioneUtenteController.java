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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            LOGGER.info("Chiamata REST /register");

            Long idUtenteRegistrato = utenteService.registrazione(utenteInInput);

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, idUtenteRegistrato);
            result.put(MESSAGGIO, "Registrazione avvenuta con successo");
            result.put(OPERAZIONE, "Registrazione Utente");

            LOGGER.info("Fine chiamata Rest /register");

            return ResponseEntity.ok().body(result);

        } catch (Exception e) {

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, -1); //-1 utente già presente, da inserire più messaggi
            result.put(MESSAGGIO, "Registrazione non avvenuta");
            result.put(OPERAZIONE, "Registrazione Utente");

            LOGGER.info("Errore nella chiamata Rest /register");

            return ResponseEntity.ok().body(result);
        }
    }

    //Login
}
