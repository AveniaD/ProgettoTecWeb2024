import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GestioneSignService {

  constructor() { }

  submitRegistration(firstName: string, lastName: string, email: string, password: string, checkPassword: string) {
    console.log(`Form per la registrazione:
      firstName: ${firstName}, lastName: ${lastName}, email: ${email},
      password: ${password}, checkPassword: ${checkPassword}.`);
   }

  submitLogin(email: string, password: string) {
    console.log(`Form per la login:
      email: ${email}, password: ${password}`);
  }
}
