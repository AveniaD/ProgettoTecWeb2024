package com.uniparthenope.innervision.service.impl.diz;

import com.uniparthenope.innervision.entity.diz.DizStatoCarrello;
import com.uniparthenope.innervision.entity.diz.DizTipologiaUtente;
import com.uniparthenope.innervision.repository.diz.DizStatoCarrelloRepository;
import com.uniparthenope.innervision.repository.diz.DizTipologiaUtenteRepository;
import com.uniparthenope.innervision.service.diz.DizTipologiaUtenteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DizTipologiaUtenteServiceImpl implements DizTipologiaUtenteService {

    @Autowired
    private DizTipologiaUtenteRepository dizTipologiaUtenteRepository;

    @Override
    public List<DizTipologiaUtente> findAllByAttivo() {
        return dizTipologiaUtenteRepository.findAllByAttivo();
    }
}
