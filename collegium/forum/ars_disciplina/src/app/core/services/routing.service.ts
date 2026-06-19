import { Injectable } from '@angular/core';
import { DeviceService } from './device.service';
import { Routes } from '@angular/router';
import { monitorRoutes } from '../router/monitor.routes';
import { phoneRoutes } from '../router/phone.routes';
import { tabletRoutes } from '../router/tablet.routes';

@Injectable({
  providedIn: 'root'
})
export class RoutingService {

  deviceService: DeviceService;
  routes: Routes = [];

  constructor(deviceService: DeviceService) {
    this.deviceService = deviceService;
    this.deviceService.setDevice();
    this.setRoutes();
  }

  setRoutes(): void {
    if (this.deviceService) {
      switch (this.deviceService.getDevice().deviceType) {
        case "phone":
          this.routes = phoneRoutes;
        break;
        case "tablet":
          this.routes = tabletRoutes;
        break;
        case "monitor":
        default:
          this.routes = monitorRoutes;
          break;
      }
    }
  }

  getRoutes(): Routes { return this.routes; }
}