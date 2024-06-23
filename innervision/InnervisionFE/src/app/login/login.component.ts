import { CommonModule } from '@angular/common';
import { Component, Injectable } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { GestioneUtenteService } from '../services/gestione-utente.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})

export class LoginComponent {

  constructor(private gestioneUtenteService: GestioneUtenteService,
    private router: Router
  ){}

  applyForm = new FormGroup({
    email: new FormControl(''),
    password: new FormControl('')
  });

  submitLogin() {
    this.gestioneUtenteService.login(
      this.applyForm.value.email ?? '',
      this.applyForm.value.password ?? ''
    );
  }
}
