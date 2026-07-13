import { Injectable } from '@angular/core';
import { Device } from '../models/device.type';

@Injectable({
  providedIn: 'root'
})
export class DeviceService {

  device: Device = Object();

  constructor() {
    this.setDevice();
  }

  setDevice(): void {
    this.device.viewportWidth = window.innerWidth;
    this.device.viewportHeight = window.innerHeight;

    if (window.innerWidth > window.innerHeight) { this.device.orientation = 'landscape'; }
    else { this.device.orientation = 'portrait'; }

    if (window.innerWidth < 600 || window.innerWidth > 600 && window.innerHeight < 415) { this.device.deviceType = 'phone'; }
    else if (window.innerWidth > 600 && window.innerWidth < 1200) { this.device.deviceType = 'tablet'; }
    else { this.device.deviceType = 'monitor'; }
  }

  getDevice(): Device { return this.device; }
}