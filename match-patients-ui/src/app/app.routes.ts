import { Routes } from '@angular/router';
import { AppComponent } from './app.component';

export const routes: Routes = [
  { path: '', pathMatch: 'full', component: AppComponent },
  { path: '**', pathMatch: 'full', redirectTo: '/' },
];
