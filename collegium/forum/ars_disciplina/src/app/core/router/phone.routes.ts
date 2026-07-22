import { Routes } from "@angular/router";

import { responsiveRoutes } from './responsive.routes';
import { AuthGuard } from "../guards/auth.guard";
import { CuratioComponent } from "../../features/pages/phone/curatio/curatio.component";
import { AnalyticaComponent } from "../../features/pages/phone/analytica/analytica.component";
import { ActariumComponent } from "../../features/pages/phone/actarium/actarium.component";
import { ConsiliumComponent } from "../../features/pages/phone/consilium/consilium.component";
import { AtriumComponent } from "../../features/pages/phone/atrium/atrium.component";
import { AdminGuard } from "../guards/admin.guard";
import { EntiaComponent } from "../../features/pages/phone/curatio/entia/entia.component";
import { AnatomiaComponent } from "../../features/pages/phone/curatio/anatomia/anatomia.component";
import { DisciplinaComponent } from "../../features/pages/phone/curatio/disciplina/disciplina.component";
import { InstrumentaComponent } from "../../features/pages/phone/curatio/instrumenta/instrumenta.component";

const routes: Routes = [
  {
    title: 'atrium',
    path: 'atrium',
    component: AtriumComponent,
    canActivate: [AuthGuard],
    runGuardsAndResolvers: 'always',
    data: {
      root: true
    }
  },
  {
    title: 'consilium',
    path: 'consilium',
    component: ConsiliumComponent,
    canActivate: [AuthGuard],
    runGuardsAndResolvers: 'always',
    data: {
      root: true
    }
  },
  {
    title: 'actarium',
    path: 'actarium',
    component: ActariumComponent,
    canActivate: [AuthGuard],
    runGuardsAndResolvers: 'always',
    data: {
      root: true
    }
  },
  {
    title: 'analytica',
    path: 'analytica',
    component: AnalyticaComponent,
    canActivate: [AuthGuard],
    runGuardsAndResolvers: 'always',
    data: {
      root: true
    }
  },
  {
    title: 'curatio',
    path: 'curatio',
    component: CuratioComponent,
    canActivate: [AuthGuard, AdminGuard],
    runGuardsAndResolvers: 'always',
    data: {
      root: true
    }
  },
  {
    title: 'entia',
    path: 'curatio/entia',
    component: EntiaComponent,
    canActivate: [AuthGuard],
    runGuardsAndResolvers: 'always'
  },
  {
    title: 'disciplina',
    path: 'curatio/disciplina',
    component: DisciplinaComponent,
    canActivate: [AuthGuard],
    runGuardsAndResolvers: 'always'
  },
   {
    title: 'anatomia',
    path: 'curatio/anatomia',
    component: AnatomiaComponent,
    canActivate: [AuthGuard],
    runGuardsAndResolvers: 'always'
  },
  {
    title: 'instrumenta',
    path: 'curatio/instrumenta',
    component: InstrumentaComponent,
    canActivate: [AuthGuard],
    runGuardsAndResolvers: 'always'
  },
]

export const phoneRoutes = routes.concat(responsiveRoutes);