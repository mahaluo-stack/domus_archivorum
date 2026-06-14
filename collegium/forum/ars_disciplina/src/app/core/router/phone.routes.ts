import { Routes } from "@angular/router";

import { responsiveRoutes } from './responsive.routes';
import { AuthGuard } from "../guards/auth.guard";
import { Atrium, Consilium, CuriaActarii } from "../../features/pages/phone";

const routes: Routes = [
  {
    title: 'atrium',
    path: 'atrium',
    component: Atrium.AtriumComponent,
    canActivate: [AuthGuard],
    runGuardsAndResolvers: 'always',
  },
  {
    title: 'consilium',
    path: 'consilium',
    component: Consilium.ConsiliumComponent,
    canActivate: [AuthGuard],
    runGuardsAndResolvers: 'always',
  },
  {
    title: 'curia actarii',
    path: 'curia-actarii',
    component: CuriaActarii.CuriaActariiComponent,
    canActivate: [AuthGuard],
    runGuardsAndResolvers: 'always',
  },
]

export const phoneRoutes = routes.concat(responsiveRoutes);