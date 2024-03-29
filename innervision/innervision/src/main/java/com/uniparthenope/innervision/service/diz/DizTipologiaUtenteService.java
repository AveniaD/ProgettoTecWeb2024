package com.uniparthenope.innervision.service.diz;

import com.uniparthenope.innervision.entity.diz.DizTipologiaUtente;

import java.util.List;

public interface DizTipologiaUtenteService {

    List<DizTipologiaUtente> findAllByAttivo();
}
