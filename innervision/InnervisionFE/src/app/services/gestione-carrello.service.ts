import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../environment';
import { Observable, map } from 'rxjs';
import { RequestGestioneCarrello } from '../interfaces/request-gestione-carrello';
import { Carrello } from '../interfaces/carrello';

@Injectable({
  providedIn: 'root'
})
export class GestioneCarrelloService {

  constructor(private http: HttpClient) { }
  readonly apiUrl = environment.apiUrl + '/carrello';

  requestGestioneCarrello!: RequestGestioneCarrello;

  showCarrello(idCarrello: number): Observable<Carrello> {
    console.log(this.apiUrl + '/showCart');
    //Da correggere, deve prendere le info dell'utente e poi ottenere l'idCarrello da li
    this.requestGestioneCarrello.idCarrello = idCarrello;
    return this.http.post<{Messaggio: string, Operazione: string, Dto: Carrello}>(
      this.apiUrl + '/showCart',this.requestGestioneCarrello).pipe(map(response => {
        console.log('Messaggio:', response.Messaggio);
        console.log('Operazione:', response.Operazione);
        console.log('Risultato:', response.Dto);
        return response.Dto;
      })
    );
  }

  addArticolo(idArticolo: number, idUtente: number, idCarrello: number): Observable<Carrello> {
    console.log(this.apiUrl + '/addArticolo');

    this.requestGestioneCarrello.idCarrello = idCarrello;
    this.requestGestioneCarrello.idUtente = idUtente;
    this.requestGestioneCarrello.idArticolo = idArticolo;

    return this.http.post<{Messaggio: string, Operazione: string, Dto: Carrello}>(
      this.apiUrl + '/addArticolo',this.requestGestioneCarrello).pipe(map(response => {
        console.log('Messaggio:', response.Messaggio);
        console.log('Operazione:', response.Operazione);
        console.log('Risultato:', response.Dto);
        return response.Dto;
      })
    );
  }

  removeArticolo(idArticolo: number, idUtente: number, idCarrello: number): Observable<Carrello> {
    console.log(this.apiUrl + '/removeArticolo');

    this.requestGestioneCarrello.idCarrello = idCarrello;
    this.requestGestioneCarrello.idUtente = idUtente;
    this.requestGestioneCarrello.idArticolo = idArticolo;

    return this.http.post<{Messaggio: string, Operazione: string, Dto: Carrello}>(
      this.apiUrl + '/removeArticolo',this.requestGestioneCarrello).pipe(map(response => {
        console.log('Messaggio:', response.Messaggio);
        console.log('Operazione:', response.Operazione);
        console.log('Risultato:', response.Dto);
        return response.Dto;
      })
    );
  }


}
