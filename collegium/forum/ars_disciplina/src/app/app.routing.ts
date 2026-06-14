import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DeviceService } from './core/services/device.service';
import { RoutingService } from './core/services/routing.service';

const getRoutes = (): Routes => {
  const routingService: RoutingService = new RoutingService(new DeviceService());
  return routingService.getRoutes();
}

@NgModule({
  imports: [RouterModule.forRoot(getRoutes())],
  exports: [RouterModule]
})
export class AppRoutingModule { }