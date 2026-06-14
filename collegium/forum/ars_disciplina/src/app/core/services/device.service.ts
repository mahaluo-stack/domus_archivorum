import { Injectable } from '@angular/core';
import { Device } from '../models/types/device.type';

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

    if (window.innerWidth < 600 || window.innerWidth > 600 && window.innerHeight < 415) { this.device.type = 'phone'; }
    else if (window.innerWidth > 600 && window.innerWidth < 1200) { this.device.type = 'tablet'; }
    else { this.device.type = 'monitor'; }
  }

  getDevice(): Device { return this.device; }
}