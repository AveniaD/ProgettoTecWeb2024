package com.uniparthenope.innervision.service.impl.diz;

import com.uniparthenope.innervision.entity.diz.DizStatoCarrello;
import com.uniparthenope.innervision.repository.diz.DizStatoCarrelloRepository;
import com.uniparthenope.innervision.service.diz.DizStatoCarrelloService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DizStatoCarrelloServiceImpl implements DizStatoCarrelloService {

    @Autowired
    private DizStatoCarrelloRepository dizStatoCarrelloRepository;

    @Override
    public List<DizStatoCarrello> findAllByAttivo() {
        return dizStatoCarrelloRepository.findAllByAttivo();
    }
}
