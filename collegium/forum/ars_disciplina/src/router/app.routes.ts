import { Routes } from '@angular/router';
import { AtriumComponent } from '../pages/atrium/atrium.component';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'atrium',
    pathMatch: 'full'
  },
  {
    path: 'atrium',
    component: AtriumComponent
  }
];
