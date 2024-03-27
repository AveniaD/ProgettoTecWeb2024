package com.uniparthenope.innervision.mapper;

import com.uniparthenope.innervision.dto.UtenteDto;
import com.uniparthenope.innervision.entity.Articolo;
import com.uniparthenope.innervision.entity.Utente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticoloDto {

    Articolo dtoToEntity(ArticoloDto articoloDto);

    ArticoloDto entityToDto(Articolo articolo);
}
