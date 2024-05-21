import { Component, Input, inject } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ArticoloComponent } from '../articolo/articolo.component';
import { Articolo } from '../interfaces/articolo';
import { GestioneArticoliService } from '../services/gestione-articoli.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    ArticoloComponent
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})

export class HomeComponent {

  articoloList: Articolo[];
  gestioneArticoliService: GestioneArticoliService = inject(GestioneArticoliService);

  constructor() {
    this.articoloList = this.gestioneArticoliService.getAllArticoli();
  }

}
