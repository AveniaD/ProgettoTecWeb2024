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

  readonly baseUrl = 'https://images.ray-ban.com/is/image/RayBan/8053672503968__002.png';

  readonly apiUrl = environment.apiUrl + '/articoli';

  getAllArticoli(): Observable<Articolo[]> {
    console.log(this.apiUrl + '/getAllArticoli');
    return this.http.get<{Messaggio: string, Operazione: string, Dto: Articolo[]}>(
      this.apiUrl + '/getAllArticoli').pipe(map(response => {
        console.log('Messaggio:', response.Messaggio);
        console.log('Operazione:', response.Operazione);
        console.log('Operazione:', response.Dto);
        return response.Dto;
      })
    );
  }

  /*getArticoliById(id: number): Articolo | undefined {
    return this.articoloList.find(articolo => articolo.idArticolo === id);
  }*/

}
