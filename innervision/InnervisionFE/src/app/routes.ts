import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { HomeComponent } from './home/home.component';
import { DetailsComponent } from './details/details.component';
import { ServiceComponent } from './service/service.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';



const routeConfig: Routes = [
  {
    path: '',
    component: HomeComponent,
    title: 'Home page'
  },
  {
    path: 'details/:id',
    component: DetailsComponent,
    title: 'Dettagli articolo'
  },
  {
    path: 'brand',
    component: LoginComponent,
    title: 'Ricerca per Brand'
  },
  {
    path: 'services',
    component: LoginComponent,
    title: 'Servizi disponibili'
  },
  {
    path: 'register',
    component: LoginComponent,
    title: 'Registrazione'
  },
  {
    path: 'login',
    component: LoginComponent,
    title: 'Login'
  }
];

@NgModule({
  imports: [
      RouterModule.forRoot(routeConfig),
    ],
  exports: [
    RouterModule
  ]
})

export class AppModule {}

export default routeConfig;
