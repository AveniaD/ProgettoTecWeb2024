import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { HomeComponent } from './home/home.component';
import { DetailsComponent } from './details/details.component';
import { ServiceComponent } from './service/service.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { BrandComponent } from './brand/brand.component';



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
    component: BrandComponent,
    title: 'Ricerca per Brand'
  },
  {
    path: 'services',
    component: ServiceComponent,
    title: 'Servizi disponibili'
  },
  {
    path: 'register',
    component: RegisterComponent,
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
