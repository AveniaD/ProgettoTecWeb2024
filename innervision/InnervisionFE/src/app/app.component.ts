import { Component } from '@angular/core';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';

import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    HomeComponent,
    RouterModule,
    NavbarComponent,
    HttpClientModule
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Innervision';
}
