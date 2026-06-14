import { ApplicationConfig } from '@angular/core';
import { provideRouter, Routes } from '@angular/router';

import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { DeviceService } from './core/services/device.service';
import { RoutingService } from './core/services/routing.service';

const getRoutes = (): Routes => {
  const routingService: RoutingService = new RoutingService(new DeviceService());
  return routingService.getRoutes();
}

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(getRoutes()), provideAnimationsAsync()]
};
