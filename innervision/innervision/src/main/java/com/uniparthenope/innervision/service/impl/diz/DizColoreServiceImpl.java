package com.uniparthenope.innervision.service.impl.diz;

import com.uniparthenope.innervision.entity.diz.DizColore;
import com.uniparthenope.innervision.repository.diz.DizColoreRepository;
import com.uniparthenope.innervision.service.diz.DizColoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DizColoreServiceImpl implements DizColoreService {

    @Autowired
    private DizColoreRepository dizColoreRepository;

    @Override
    public List<DizColore> findAllByAttivo() {
        return dizColoreRepository.findAllByAttivo();
    }
}
