import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { DizCategoria } from '../interfaces/diz/diz-categoria';
import { DizMarchio } from '../interfaces/diz/diz-marchio';
import { GestioneDizionariService } from '../services/gestione-dizionari.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ArticoloComponent } from '../articolo/articolo.component';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [
    CommonModule,
    ArticoloComponent,
    RouterModule,
    FormsModule
  ],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  showDropdown: boolean = false;
  categorieDisponibili!: DizCategoria[];
  marcheDisponibili!: DizMarchio[];

  constructor(private gestioneDizionariService: GestioneDizionariService) {}

  ngOnInit(): void {
    this.gestioneDizionariService.getCategoria().subscribe(
      (data) => {
        this.categorieDisponibili = data;
        this.showDropdown = true;
      },
      (error) => {
        console.error('Errore durante il recupero delle categorie', error);
      }
    );

    this.gestioneDizionariService.getMarche().subscribe(
      (data) => {
        this.marcheDisponibili = data;

      },
      (error) => {
        console.error('Errore durante il recupero delle marche', error);
      }
    );
  }

  onMouseEnter(): void {
    this.showDropdown = true;
  }

  onMouseLeave(): void {
    this.showDropdown = false;
  }
}
