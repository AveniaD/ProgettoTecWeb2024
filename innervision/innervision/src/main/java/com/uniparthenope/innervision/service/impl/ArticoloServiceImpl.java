package com.uniparthenope.innervision.service.impl;

import com.uniparthenope.innervision.dto.ArticoloDto;
import com.uniparthenope.innervision.entity.Articolo;
import com.uniparthenope.innervision.mapper.ArticoloMapper;
import com.uniparthenope.innervision.repository.ArticoloRepository;
import com.uniparthenope.innervision.service.ArticoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticoloServiceImpl implements ArticoloService {

    @Autowired
    private ArticoloRepository articoloRepository;

    @Autowired
    private ArticoloMapper articoloMapper;

    @Override
    public List<ArticoloDto> findAllArticoli() {
        return articoloMapper.toDtoList(articoloRepository.findAll());
    }

    @Override
    public ArticoloDto findArticoloById(Long idArticolo) {
        Optional<Articolo> articoloTrovato = articoloRepository.findById(idArticolo);
        return articoloMapper.entityToDto(articoloTrovato.orElseGet(Articolo::new));
    }

    @Override
    public List<ArticoloDto> findArticoloByNome(String nome) {
        return articoloMapper.toDtoList(articoloRepository.findArticoloByNome(nome));
    }
}
