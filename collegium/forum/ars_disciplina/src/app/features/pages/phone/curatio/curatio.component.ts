import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-curatio',
  standalone: true,
  imports: [ RouterLink,
    MatListModule,
    MatIconModule],
  templateUrl: './curatio.component.html',
  styleUrl: './curatio.component.scss'
})
export class CuratioComponent {
  sections = [
    {
      title: 'exercises',
      icon: 'physical_therapy',
      route: '/curatio/exercises'
    },
    {
      title: 'muscles',
      icon: 'accessibility_new',
      route: '/curatio/muscles'
    },
    {
      title: 'equipment',
      icon: 'fitness_center',
      route: '/curatio/equipment'
    },
    {
      title: 'archetypes',
      icon: 'category',
      route: '/curatio/archetypes'
    }
  ];
}
