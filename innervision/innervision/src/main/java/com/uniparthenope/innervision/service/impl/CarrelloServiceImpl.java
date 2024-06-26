package com.uniparthenope.innervision.service.impl;

import com.uniparthenope.innervision.common.RequestGestioneCarrello;
import com.uniparthenope.innervision.dto.CarrelloDto;
import com.uniparthenope.innervision.entity.Articolo;
import com.uniparthenope.innervision.entity.Carrello;
import com.uniparthenope.innervision.entity.Utente;
import com.uniparthenope.innervision.entity.diz.DizStatoCarrello;
import com.uniparthenope.innervision.mapper.CarrelloMapper;
import com.uniparthenope.innervision.repository.ArticoloRepository;
import com.uniparthenope.innervision.repository.CarrelloRepository;
import com.uniparthenope.innervision.repository.UtenteRepository;
import com.uniparthenope.innervision.repository.diz.DizStatoCarrelloRepository;
import com.uniparthenope.innervision.service.CarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrelloServiceImpl implements CarrelloService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private CarrelloRepository carrelloRepository;

    @Autowired
    private ArticoloRepository articoloRepository;

    @Autowired
    private DizStatoCarrelloRepository dizStatoCarrelloRepository;

    @Autowired
    private CarrelloMapper carrelloMapper;

    @Override
    public Boolean addArticolo(RequestGestioneCarrello requestGestioneCarrelloInInput) {
        Articolo articoloDaAggiungere = articoloRepository.getArticoloByIdArticolo(requestGestioneCarrelloInInput.getIdArticolo());
        Carrello carrelloDaAggiornare = carrelloRepository.getCarrelloByIdCarrello(requestGestioneCarrelloInInput.getIdCarrello());
        Utente utenteTrovato = utenteRepository.getUtenteByIdUtente(requestGestioneCarrelloInInput.getIdUtente());

        checkRequestGestioneCarrello(requestGestioneCarrelloInInput);

        carrelloDaAggiornare.getArticoli().add(articoloDaAggiungere);
        utenteTrovato.setCarrelloUtente(carrelloDaAggiornare);

        carrelloRepository.save(carrelloDaAggiornare);
        utenteRepository.save(utenteTrovato);

        return true;
    }

    @Override
    public Boolean removeArticolo(RequestGestioneCarrello requestGestioneCarrelloInInput) {
        Articolo articoloDaRimuovere = articoloRepository.getArticoloByIdArticolo(requestGestioneCarrelloInInput.getIdArticolo());
        Carrello carrelloDaAggiornare = carrelloRepository.getCarrelloByIdCarrello(requestGestioneCarrelloInInput.getIdCarrello());
        Utente utenteTrovato = utenteRepository.getUtenteByIdUtente(requestGestioneCarrelloInInput.getIdUtente());

        checkRequestGestioneCarrello(requestGestioneCarrelloInInput);
        if(carrelloDaAggiornare.getArticoli().isEmpty()){
            throw new RuntimeException("Il carrello trovato è già vuoto");
        }

        carrelloDaAggiornare.getArticoli().remove(articoloDaRimuovere);
        utenteTrovato.setCarrelloUtente(carrelloDaAggiornare);

        carrelloRepository.save(carrelloDaAggiornare);
        utenteRepository.save(utenteTrovato);
        return true;
    }

    @Override
    public CarrelloDto showCarrello(RequestGestioneCarrello requestGestioneCarrelloInInput) {
        return carrelloMapper.entityToDto(
                carrelloRepository.getCarrelloByIdCarrello(requestGestioneCarrelloInInput.getIdCarrello())
        );
    }

    @Override
    public Boolean svuotaCarrello(RequestGestioneCarrello requestGestioneCarrelloInInput) {
        Carrello carrelloDaAggiornare = carrelloRepository.getCarrelloByIdCarrello(requestGestioneCarrelloInInput.getIdCarrello());
        Utente utenteTrovato = utenteRepository.getUtenteByIdUtente(requestGestioneCarrelloInInput.getIdUtente());

        checkRequestCarrello(requestGestioneCarrelloInInput);
        if(carrelloDaAggiornare.getStatoCarrello().getIdStatoCarrello() > 1)
            return false;

        carrelloDaAggiornare.getArticoli().clear();
        utenteTrovato.setCarrelloUtente(carrelloDaAggiornare);

        carrelloRepository.save(carrelloDaAggiornare);
        utenteRepository.save(utenteTrovato);

        return true;
    }

    @Override
    public Boolean cambiaStatoCarrello(RequestGestioneCarrello requestGestioneCarrelloInInput) {
        Carrello carrelloDaAggiornare = carrelloRepository.getCarrelloByIdCarrello(requestGestioneCarrelloInInput.getIdCarrello());
        //Utente utenteTrovato = utenteRepository.getUtenteByIdUtente(requestGestioneCarrelloInInput.getIdUtente());

        checkRequestCarrello(requestGestioneCarrelloInInput);
        if(requestGestioneCarrelloInInput.getIdStatoCarrello() >
                carrelloDaAggiornare.getStatoCarrello().getIdStatoCarrello())
            return false;

        carrelloDaAggiornare.setStatoCarrello(
                dizStatoCarrelloRepository.getById(requestGestioneCarrelloInInput.getIdStatoCarrello()));
        carrelloRepository.save(carrelloDaAggiornare);

        return true;
    }

    private void checkRequestGestioneCarrello(RequestGestioneCarrello requestToCheck){
        if(requestToCheck.getIdArticolo() == null){
            throw new RuntimeException("Articolo non trovato");
        }

        if(requestToCheck.getIdCarrello() == null){
            throw new RuntimeException("Carrello non trovato");
        }

        if(requestToCheck.getIdUtente() == null){
            throw new RuntimeException("Utente non trovato");
        }
    }


    private void checkRequestCarrello(RequestGestioneCarrello requestToCheck){
        if(requestToCheck.getIdCarrello() == null){
            throw new RuntimeException("Carrello non trovato");
        }

        if(requestToCheck.getIdUtente() == null){
            throw new RuntimeException("Utente non trovato");
        }
    }
}
