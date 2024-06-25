package com.uniparthenope.innervision.controller;

import static com.uniparthenope.innervision.common.DefaultStrings.*;

import com.uniparthenope.innervision.common.RequestLogin;
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
            result.put(DTO, -1);
            result.put(MESSAGGIO, "Registrazione fallita");
            result.put(OPERAZIONE, "Registrazione Utente");

            LOGGER.info("Errore nella chiamata Rest /register");
            LOGGER.error(MESSAGGIO_ERRORE, e);

            return ResponseEntity.ok().body(result);
        }
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Effettua la registrazione di un utente",
            notes = "Restituisce l'utente registrato.",
            response = UtenteDto.class)
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody RequestLogin requestLogin) {
        try {
            LOGGER.info("Chiamata REST /login");

            String tokenLogin = utenteService.login(requestLogin);

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, tokenLogin);
            result.put(MESSAGGIO, "Login avvenuta con successo");
            result.put(OPERAZIONE, "Login Utente");

            LOGGER.info("Fine chiamata Rest /Login");

            return ResponseEntity.ok().body(result);

        } catch (Exception e) {

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, -1);
            result.put(MESSAGGIO, "Login fallito");
            result.put(OPERAZIONE, "Login Utente");

            LOGGER.info("Errore nella chiamata Rest /Login");
            LOGGER.error(MESSAGGIO_ERRORE, e);

            return ResponseEntity.ok().body(result);
        }
    }
}
