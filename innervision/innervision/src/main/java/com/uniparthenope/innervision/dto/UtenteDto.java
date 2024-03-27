package com.uniparthenope.innervision.dto;

import com.uniparthenope.innervision.entity.Carrello;
import com.uniparthenope.innervision.entity.diz.DizTipologiaUtente;
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
public class UtenteDto {

    private Long idUtente;

    private String username;

    private String password;

    private DizTipologiaUtente tipologiaUtente;

    private Carrello carrelloUtente;
}
