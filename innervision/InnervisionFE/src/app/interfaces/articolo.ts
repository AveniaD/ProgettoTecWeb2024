import { DizCategoria } from "./diz/diz-categoria";
import { DizColore } from "./diz/diz-colore";
import { DizGenere } from "./diz/diz-genere";
import { DizMarchio } from "./diz/diz-marchio";

export interface Articolo {
  idArticolo: number;
  nome: string;
  foto: string;
  quantitaDisponibile: number;
  descrizione: string;
  marchio: DizMarchio;
  genere: DizGenere;
  coloreMontatura: DizColore;
  coloreLente: DizColore;
  categoria: DizCategoria;
}
