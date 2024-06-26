import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Utente } from '../interfaces/utente';
import { environment } from '../environment';
import { Observable, map } from 'rxjs';
import { RequestLogin } from '../interfaces/request-login';

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

  login(username: string, password: string) {
    console.log(this.apiUrl + '/login');
    let requestLogin = new RequestLogin(
      username? username : '',
      password? password : ''
    );

    return this.http.post<{Messaggio: string, Operazione: string, Dto: any}>(
      this.apiUrl + '/login', requestLogin).pipe(map
      (response => {
        console.log('Messaggio:', response.Messaggio);
        console.log('Operazione:', response.Operazione);
        console.log('Risultato:', response.Dto);
        return response.Dto;
      })
    );
  }
}
