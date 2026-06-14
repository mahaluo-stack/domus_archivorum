import { Routes } from "@angular/router";
import { AuthGuard } from "../guards/auth.guard";
import * as ResponsivePages from '../../features/pages/responsive';
import { LoginComponent, LogOutComponent, NotFoundComponent } from '../../features/pages/common';

export const responsiveRoutes: Routes = [
  {
    path: '',
    pathMatch: 'prefix',
    redirectTo: 'log in'
  },
  {
    title: 'log in',
    path: 'log in',
    component: LoginComponent
  },
  {
    path: 'log out',
    component: LogOutComponent,
    canActivate: [AuthGuard],
    runGuardsAndResolvers: 'always',
  },
  {
    path: 'atrium',
    component: ResponsivePages.AtriumComponent
  },
  {
    path: 'consilium',
    component: ResponsivePages.ConsiliumComponent
  },
  {
    path: 'curia-actarii',
    component: ResponsivePages.CuriaActariiComponent
  },
  {
    path: '404',
    component: NotFoundComponent
  },
  {
    path: '**',
    redirectTo: '404'
  },
]