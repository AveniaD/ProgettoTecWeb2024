import { Injectable } from '@angular/core';
import { Articolo } from '../interfaces/articolo';

import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { environment } from '../environment';

@Injectable({
  providedIn: 'root'
})

export class GestioneArticoliService {

  constructor(private http: HttpClient) { }

  readonly apiUrl = environment.apiUrl + '/articoli';

  getAllArticoli(): Observable<Articolo[]> {
    console.log(this.apiUrl + '/getAllArticoli');
    return this.http.get<{Messaggio: string, Operazione: string, Dto: Articolo[]}>(
      this.apiUrl + '/getAllArticoli').pipe(map(response => {
        console.log('Messaggio:', response.Messaggio);
        console.log('Operazione:', response.Operazione);
        console.log('Risultato:', response.Dto);
        return response.Dto;
      })
    );
  }

  getArticoliById(id: number): Observable<Articolo>{
    console.log(this.apiUrl + '/getArticoloById?id=' + id);
    return this.http.get<{Messaggio: string, Operazione: string, Dto: Articolo}>(
      this.apiUrl + '/getArticoloById?id='+ id).pipe(map(response => {
        console.log('Messaggio:', response.Messaggio);
        console.log('Operazione:', response.Operazione);
        console.log('Risultato:', response.Dto);
        return response.Dto;
      })
    );
  }

  getArticoliByNome(nome: String): Observable<Articolo[]>{
    console.log(this.apiUrl + '/getArticoliByNome?nome=' + nome);
    return this.http.get<{Messaggio: string, Operazione: string, Dto: Articolo[]}>(
      this.apiUrl + '/getArticoliByNome?nome='+ nome).pipe(map(response => {
        console.log('Messaggio:', response.Messaggio);
        console.log('Operazione:', response.Operazione);
        console.log('Risultato:', response.Dto);
        return response.Dto;
      })
    );
  }

}
