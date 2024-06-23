import { Articolo } from "./articolo";
import { DizTipologiaUtente } from "./diz/diz-tipologia-utente";

export class Utente {
  idUtente: number | undefined;
  nome: string;
  cognome: string;
  username: string;
  email: string;
  password: string;
  tipologiaUtente: DizTipologiaUtente;
  carrello: Array<Articolo>;

  constructor(nome: string, cognome: string, username: string,
    email: string, password: string) {
      this.nome = nome;
      this.cognome = cognome;
      this.username = username;
      this.email = email;
      this.password = password;
      this.tipologiaUtente = new DizTipologiaUtente;
      this.carrello = new Array<Articolo>();
  }
}
