package com.uniparthenope.innervision.service.impl.diz;

import com.uniparthenope.innervision.entity.diz.DizMarchio;
import com.uniparthenope.innervision.repository.diz.DizMarchioRepository;
import com.uniparthenope.innervision.service.diz.DizMarchioService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DizMarchioServiceImpl implements DizMarchioService {

    @Autowired
    private DizMarchioRepository dizMarchioRepository;
    @Override
    public List<DizMarchio> findAllByAttivo() {
        return dizMarchioRepository.findAllByAttivo();
    }
}
