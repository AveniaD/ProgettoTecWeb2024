package com.uniparthenope.innervision.dto;

import com.uniparthenope.innervision.entity.Articolo;
import com.uniparthenope.innervision.entity.diz.DizStatoCarrello;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarrelloDto {

    private Long idCarrello;

    private List<Articolo> articoli;

    private DizStatoCarrello statoCarrello;
}
