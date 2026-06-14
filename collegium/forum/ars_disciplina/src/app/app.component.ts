import { Component, inject } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UserService } from './core/services/user.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'ars_disciplina';
  userService: UserService = inject(UserService);

  constructor() {
    let current = localStorage.getItem("rememberMe");
    if (current !== null) { this.userService.currentUser.next({ id: "1", name: current }); }
  }
}