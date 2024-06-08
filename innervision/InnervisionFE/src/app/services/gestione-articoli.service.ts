import { Injectable } from '@angular/core';
import { Articolo } from '../interfaces/articolo';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../environment';

@Injectable({
  providedIn: 'root'
})

export class GestioneArticoliService {

  readonly baseUrl = 'https://images.ray-ban.com/is/image/RayBan/8053672503968__002.png';

  articoloList: Articolo[] = [
    {
      id: 1,
      name: 'Ray ban neri',
      photo: this.baseUrl,
      availableUnits: 3,
      description: 'descrizione 1'
    },
    {
      id: 2,
      name: 'Occhiali da vista bianchi',
      photo: this.baseUrl,
      availableUnits: 3,
      description: 'descrizione 1'
    },
    {
      id: 3,
      name: 'Test Occhiali',
      photo: this.baseUrl,
      availableUnits: 3,
      description: 'descrizione 1'
    },
    {
      id: 4,
      name: 'Test Occhiali',
      photo: this.baseUrl,
      availableUnits: 3,
      description: 'descrizione 1'
    },
    {
      id: 5,
      name: 'Test Occhiali',
      photo: this.baseUrl,
      availableUnits: 3,
      description: 'descrizione 1'
    },
    {
      id: 6,
      name: 'Test Occhiali',
      photo: this.baseUrl,
      availableUnits: 3,
      description: 'descrizione 1'
    },
    {
      id: 7,
      name: 'Test Occhiali',
      photo: this.baseUrl,
      availableUnits: 3,
      description: 'descrizione 1'
    }
  ];

  constructor() { }

  getAllArticoli(): Articolo[] {
    return this.articoloList;
  }

  getArticoliById(id: number): Articolo | undefined {
    return this.articoloList.find(articolo => articolo.id === id);
  }

}
