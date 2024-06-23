import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Utente } from '../interfaces/utente';
import { environment } from '../environment';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GestioneUtenteService {

  constructor(private http: HttpClient) { }
  readonly apiUrl = environment.apiUrl + '/user';

  register(utente: Utente): Observable<any> {
    console.log(this.apiUrl + '/register');
    return this.http.post<{Messaggio: string, Operazione: string, Dto: any}>(
      this.apiUrl + '/register', utente).pipe(map
      (response => {
        console.log('Messaggio:', response.Messaggio);
        console.log('Operazione:', response.Operazione);
        console.log('Risultato:', response.Dto);
        return response.Dto;
      })
    );
  }

  login(email: string, password: string) {
    console.log(`Form per la login:
      email: ${email}, password: ${password}`);
  }
}
