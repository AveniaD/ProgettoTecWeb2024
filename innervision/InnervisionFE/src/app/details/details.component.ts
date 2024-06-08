import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';

import { Articolo } from '../interfaces/articolo';
import { GestioneArticoliService } from '../services/gestione-articoli.service';


@Component({
  selector: 'app-details',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule],
  templateUrl: './details.component.html',
  styleUrl: './details.component.css'
})

export class DetailsComponent {

  gestioneArticoliService: GestioneArticoliService = new GestioneArticoliService;
  articolo: Articolo | undefined;
  route: ActivatedRoute = inject(ActivatedRoute);

  constructor() {
    const articoloId = parseInt(this.route.snapshot.params['id'], 3);
    this.articolo = this.gestioneArticoliService.getArticoliById(articoloId);
  }

}
