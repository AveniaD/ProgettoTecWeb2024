import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Utente } from '../interfaces/utente';
import { environment } from '../environment';
import { Observable, map } from 'rxjs';
import { RequestLogin } from '../interfaces/request-login';
import { InfoUtente } from '../interfaces/info-utente';
import { Carrello } from '../interfaces/carrello';

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

    return this.http.post<{Messaggio: string, Operazione: string,
      Token: string,
      UtenteLoggato: InfoUtente,
      Carrello: Carrello}>(
      this.apiUrl + '/login', requestLogin).pipe(map
      (response => {
        console.log('Messaggio:', response.Messaggio);
        console.log('Operazione:', response.Operazione);
        console.log('Token:', response.Token);
        console.log('UtenteLoggato:', response.UtenteLoggato);
        console.log('Carrello:', response.Carrello);
        if (response.Token) {
          localStorage.setItem('jwtToken', response.Token);
          localStorage.setItem('usernameLoggato', response.UtenteLoggato.username);
          localStorage.setItem('idCarrello', response.Carrello.idCarrello.toString());
        }else{
          localStorage.removeItem('jwtToken');
        }
        return response.Token;
      })
    );
  }

  logout(): void {
    localStorage.removeItem('jwtToken');
    localStorage.removeItem('usernameLoggato');
  }

  getToken(): string {
    return localStorage.getItem('jwtToken')?.toString() || '';

  }

  getUsername(): string{
    return localStorage.getItem('usernameLoggato')?.toString() || '';
  }

  getIdCarrello(): number{
    return Number(localStorage.getItem('idCarrello'));
  }

}
