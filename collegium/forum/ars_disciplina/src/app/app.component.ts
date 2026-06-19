import { Component, inject } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UserService } from './core/services/user.service';
import { DeviceService } from './core/services/device.service';
import { MenuNavigatorComponent } from './features/components/phone/menu-navigator/menu-navigator.component';
import { Role } from './core/models/constants/roles.enum';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MenuNavigatorComponent],
  providers: [DeviceService],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'ars disciplina';
  userService: UserService = inject(UserService);
  deviceService: DeviceService = inject(DeviceService);
  protected readonly device = this.deviceService.getDevice().deviceType;

  constructor() {
    let current = localStorage.getItem("rememberMe");
    if (current !== null) { this.userService.currentUser.next({ id: 1, email: current, name: 'test', roles: [Role.Administrator] }); }
  }
}