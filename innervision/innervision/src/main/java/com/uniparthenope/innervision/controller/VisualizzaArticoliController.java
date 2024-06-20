package com.uniparthenope.innervision.controller;

import static com.uniparthenope.innervision.common.DefaultStrings.*;

import com.uniparthenope.innervision.dto.ArticoloDto;
import com.uniparthenope.innervision.service.ArticoloService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/articoli")
public class VisualizzaArticoliController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VisualizzaArticoliController.class);

    @Autowired
    private ArticoloService articoloService;

    @GetMapping(value = "/getAllArticoli", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ottieni tutti gli articoli",
            notes = "Restituisce una lista di categorie disponibili.",
            response = ArticoloDto.class)
    public ResponseEntity<Map<String, Object>> getAllArticoli(){
        try{
            LOGGER.info("Chiamata REST /getAllArticoli");

            List<ArticoloDto> dto = articoloService.findAllArticoli();

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, dto);
            result.put(MESSAGGIO, "Lista degli articoli");
            result.put(OPERAZIONE, "Info Articoli");

            LOGGER.info("Fine chiamata Rest /getAllArticoli");

            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            LOGGER.error(MESSAGGIO_ERORE, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGGIO_ERORE, e);

        }
    }

    @GetMapping(value = "/getArticoloById", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ottieni un articolo tramite un id",
            notes = "Restituisce un articolo tramite un id.",
            response = ArticoloDto.class)
    public ResponseEntity<Map<String, Object>> getArticoloById(@RequestParam Long id){
        try{
            LOGGER.info("Chiamata REST /getArticoloById");

            ArticoloDto dto = articoloService.findArticoloById(id);

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, dto);
            result.put(MESSAGGIO, "Articolo trovato tramite id");
            result.put(OPERAZIONE, "Info Articolo");

            LOGGER.info("Fine chiamata Rest /getArticoloById");

            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            LOGGER.error(MESSAGGIO_ERORE, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGGIO_ERORE, e);

        }
    }

    @GetMapping(value = "/getArticoliByNome", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ottieni un articolo tramite un id",
            notes = "Restituisce un articolo tramite un id.",
            response = ArticoloDto.class)
    public ResponseEntity<Map<String, Object>> getArticoliByNome(@RequestParam String nome){
        try{
            LOGGER.info("Chiamata REST /getArticoliByNome");

            List<ArticoloDto> dto = articoloService.findArticoloByNome(nome);

            Map<String, Object> result = new HashMap<>();
            result.put(DTO, dto);
            result.put(MESSAGGIO, "Articoli trovati tramite nome");
            result.put(OPERAZIONE, "Info Articolo");

            LOGGER.info("Fine chiamata Rest /getArticoliByNome");

            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            LOGGER.error(MESSAGGIO_ERORE, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MESSAGGIO_ERORE, e);

        }
    }
}
