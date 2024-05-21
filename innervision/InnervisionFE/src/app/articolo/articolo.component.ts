import { Component, Input } from '@angular/core';
import { Articolo } from '../interfaces/articolo';

@Component({
  selector: 'app-articolo',
  standalone: true,
  imports: [],
  templateUrl: './articolo.component.html',
  styleUrl: './articolo.component.css'
})
export class ArticoloComponent {
  @Input() articolo!: Articolo;
}
