import { CommonModule } from '@angular/common';
import { Component, Injectable } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { GestioneSignService } from '../services/gestione-sign.service';

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

  gestioneSignService: GestioneSignService = new GestioneSignService;

  applyForm = new FormGroup({
    email: new FormControl(''),
    password: new FormControl('')
  });

  submitLogin() {
    this.gestioneSignService.submitLogin(
      this.applyForm.value.email ?? '',
      this.applyForm.value.password ?? ''
    );
  }
}
