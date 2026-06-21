import { Routes } from "@angular/router";

import { responsiveRoutes } from './responsive.routes';
import { AuthGuard } from "../guards/auth.guard";
import { CuratioComponent } from "../../features/pages/phone/curatio/curatio.component";
import { AnalyticaComponent } from "../../features/pages/phone/analytica/analytica.component";
import { ActariumComponent } from "../../features/pages/phone/actarium/actarium.component";
import { ConsiliumComponent } from "../../features/pages/phone/consilium/consilium.component";
import { AtriumComponent } from "../../features/pages/phone/atrium/atrium.component";
import { AdminGuard } from "../guards/admin.guard";
import { MusclesComponent } from "../../features/pages/phone/curatio/muscles/muscles.component";
import { ExercisesComponent } from "../../features/pages/phone/curatio/exercises/exercises.component";
import { ArchetypesComponent } from "../../features/pages/phone/curatio/archetypes/archetypes.component";
import { EquipmentComponent } from "../../features/pages/phone/curatio/equipment/equipment.component";

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
    title: 'archetypes',
    path: 'curatio/archetypes',
    component: ArchetypesComponent,
    canActivate: [AuthGuard],
    runGuardsAndResolvers: 'always'
  },
  {
    title: 'exercises',
    path: 'curatio/exercises',
    component: ExercisesComponent,
    canActivate: [AuthGuard],
    runGuardsAndResolvers: 'always'
  },
  {
    title: 'muscles',
    path: 'curatio/muscles',
    component: MusclesComponent,
    canActivate: [AuthGuard],
    runGuardsAndResolvers: 'always'
  },
  {
    title: 'equipment',
    path: 'curatio/equipment',
    component: EquipmentComponent,
    canActivate: [AuthGuard],
    runGuardsAndResolvers: 'always'
  },
]

export const phoneRoutes = routes.concat(responsiveRoutes);