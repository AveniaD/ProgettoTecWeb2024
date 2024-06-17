import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ArticoloComponent } from '../articolo/articolo.component';
import { Articolo } from '../interfaces/articolo';
import { GestioneArticoliService } from '../services/gestione-articoli.service';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    ArticoloComponent,
    RouterModule,
    FormsModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})

export class HomeComponent implements OnInit {

  articoloList: Articolo[] = [];
  ricercaNome: string = ''

  constructor(private gestioneArticoliService: GestioneArticoliService) { }

  ngOnInit(): void {
    this.gestioneArticoliService.getAllArticoli().subscribe(
      (data: Articolo[]) => {
        this.articoloList = data;
      },
      error => {
        console.error('Errore durante il recupero degli articoli', error);
      }
    );
  }

  ricercaPerNome(): void{
    if (!this.ricercaNome) {
      console.error('Il nome non può essere vuoto');
      return;
    }

    this.gestioneArticoliService.getArticoliByNome(this.ricercaNome).subscribe(
      (data: Articolo[]) => {
        this.articoloList = data;
      },
      error => {
        console.error('Errore durante il recupero degli articoli', error);
      }
    );
  }
}
