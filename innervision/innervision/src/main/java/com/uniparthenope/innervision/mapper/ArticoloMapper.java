package com.uniparthenope.innervision.mapper;

import com.uniparthenope.innervision.dto.ArticoloDto;
import com.uniparthenope.innervision.entity.Articolo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticoloMapper {

    Articolo dtoToEntity(ArticoloDto articoloDto);

    ArticoloDto entityToDto(Articolo articolo);
}
