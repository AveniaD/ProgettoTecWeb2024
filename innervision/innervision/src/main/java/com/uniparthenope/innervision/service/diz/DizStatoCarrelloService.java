package com.uniparthenope.innervision.service.diz;

import com.uniparthenope.innervision.entity.diz.DizStatoCarrello;

import java.util.List;

public interface DizStatoCarrelloService {

    List<DizStatoCarrello> findAllByAttivo();
}
