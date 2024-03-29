package com.uniparthenope.innervision.service.impl.diz;

import com.uniparthenope.innervision.entity.diz.DizCategoria;
import com.uniparthenope.innervision.repository.diz.DizCategoriaRepository;
import com.uniparthenope.innervision.service.diz.DizCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DizCategoriaServiceImpl implements DizCategoriaService {

    @Autowired
    private DizCategoriaRepository dizCategoriaRepository;

    @Override
    public List<DizCategoria> findAll() {
        return dizCategoriaRepository.findAll();
    }
}
