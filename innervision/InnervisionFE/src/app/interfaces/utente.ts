import { Articolo } from "./articolo";
import { Carrello } from "./carrello";
import { DizTipologiaUtente } from "./diz/diz-tipologia-utente";

export class Utente {
  idUtente: number | undefined;
  nome: string;
  cognome: string;
  username: string;
  email: string;
  password: string;
  tipologiaUtente: DizTipologiaUtente;
  carrello: Carrello;

  constructor(nome: string, cognome: string, username: string,
    email: string, password: string, carrello: Carrello) {
      this.nome = nome;
      this.cognome = cognome;
      this.username = username;
      this.email = email;
      this.password = password;
      this.tipologiaUtente = new DizTipologiaUtente(1, "Cliente","S");
      this.carrello = carrello;
  }
}
