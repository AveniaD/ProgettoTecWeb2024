package com.uniparthenope.innervision.dto;

import com.uniparthenope.innervision.entity.diz.DizCategoria;
import com.uniparthenope.innervision.entity.diz.DizColore;
import com.uniparthenope.innervision.entity.diz.DizGenere;
import com.uniparthenope.innervision.entity.diz.DizMarchio;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticoloDto {

    private Long idArticolo;

    private String nome;

    private Integer recensioni;

    //Aggiungere da quante persone è stato salvato per supportare il sistema
    //di raccomandazioni?

    private DizMarchio marchio;

    private DizGenere genere;

    private DizColore coloreMontatura;

    private DizColore coloreLente;

    private DizCategoria categoria;
}
