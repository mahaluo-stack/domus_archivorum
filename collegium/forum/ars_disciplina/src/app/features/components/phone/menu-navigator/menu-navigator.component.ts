import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'menu-navigator',
  standalone: true,
  imports: [
    RouterLink,
    RouterLinkActive
  ],
  templateUrl: './menu-navigator.component.html',
  styleUrl: './menu-navigator.component.scss'
})
export class MenuNavigatorComponent {
}