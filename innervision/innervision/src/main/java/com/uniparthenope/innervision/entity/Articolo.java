package com.uniparthenope.innervision.entity;

import com.uniparthenope.innervision.entity.diz.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ARTICOLO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Articolo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_ARTICOLO", nullable = false)
    private Long idArticolo;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name ="RECENSIONI", length = 1)
    private Integer recensioni;

    //Aggiungere da quante persone è stato salvato per supportare il sistema
    //di raccomandazioni?

    @Column(name ="quantitaDisponibile")
    private Integer quantitaDisponibile;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_DIZ_MARCHIO")
    private DizMarchio marchio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_DIZ_GENERE")
    private DizGenere genere;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_DIZ_COLORE_MONTATURA")
    private DizColore coloreMontatura;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_DIZ_COLORE_LENTE")
    private DizColore coloreLente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_DIZ_CATEGORIA")
    private DizCategoria categoria;
}
