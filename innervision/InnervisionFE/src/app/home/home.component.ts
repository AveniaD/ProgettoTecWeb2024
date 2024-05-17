import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ArticoloComponent } from '../articolo/articolo.component';
import { Articolo } from '../interfaces/articolo';

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

  readonly baseUrl = 'https://images.ray-ban.com/is/image/RayBan/8053672503968__002.png';

  articoloMostrato: Articolo = {
    id: 9999,
    name: 'Test Occhiali',
    photo: `${this.baseUrl}`,
    availableUnits: 99
  };
}
