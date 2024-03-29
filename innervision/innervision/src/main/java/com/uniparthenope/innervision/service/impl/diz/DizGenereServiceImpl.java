package com.uniparthenope.innervision.service.impl.diz;

import com.uniparthenope.innervision.entity.diz.DizGenere;
import com.uniparthenope.innervision.repository.diz.DizGenereRepository;
import com.uniparthenope.innervision.service.diz.DizGenereService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DizGenereServiceImpl implements DizGenereService {

    @Autowired
    private DizGenereRepository dizGenereRepository;

    @Override
    public List<DizGenere> findAllByAttivo() {
        return dizGenereRepository.findAllByAttivo();
    }
}
