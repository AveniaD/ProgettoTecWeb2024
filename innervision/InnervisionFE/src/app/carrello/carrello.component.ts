import { Component, OnInit } from '@angular/core';
import { Articolo } from '../interfaces/articolo';
import { GestioneCarrelloService } from '../services/gestione-carrello.service';
import { Carrello } from '../interfaces/carrello';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { ArticoloComponent } from '../articolo/articolo.component';
import { GestioneUtenteService } from '../services/gestione-utente.service';

@Component({
  selector: 'app-carrello',
  standalone: true,
  imports: [
    CommonModule,
    ArticoloComponent,
    RouterModule,
    FormsModule
  ],
  templateUrl: './carrello.component.html',
  styleUrl: './carrello.component.css'
})
export class CarrelloComponent implements OnInit{

  carrello!: Carrello;

  constructor(private gestioneCarrelloService: GestioneCarrelloService,
    private gestioneUtenteService: GestioneUtenteService){}

  ngOnInit(): void {
    if(this.gestioneUtenteService.getIdCarrello()){
      let idCarrelloAttuale = this.gestioneUtenteService.getIdCarrello()!;
      this.gestioneCarrelloService.showCarrello(idCarrelloAttuale).subscribe(
        (data: Carrello) => {
          console.log(data);
          this.carrello = data;
        },
        error => {
          console.error('Errore durante il recupero del carrello', error);
        }
      );
    }else{
      this.carrello = new Carrello();
    }
  }
}
