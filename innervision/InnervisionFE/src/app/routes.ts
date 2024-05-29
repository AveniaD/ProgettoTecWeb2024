import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { DetailsComponent } from './details/details.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';

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
    path: 'login/',
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
