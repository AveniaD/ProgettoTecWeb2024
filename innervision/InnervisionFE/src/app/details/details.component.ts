import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';

import { Articolo } from '../interfaces/articolo';
import { GestioneArticoliService } from '../services/gestione-articoli.service';
import { HttpClient } from '@angular/common/http';


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

  gestioneArticoliService: GestioneArticoliService = new GestioneArticoliService(
    inject(HttpClient)
  );
  articolo!: Articolo;
  route: ActivatedRoute = inject(ActivatedRoute);

  constructor() {
    const idArticolo = parseInt(this.route.snapshot.params['id']);
    this.gestioneArticoliService.getArticoliById(idArticolo).subscribe(
      (data: Articolo) => {
        this.articolo = data;
      },
      error => {
        console.error('Errore durante il recupero dell articolo', error);
      }
    );
  }

}
