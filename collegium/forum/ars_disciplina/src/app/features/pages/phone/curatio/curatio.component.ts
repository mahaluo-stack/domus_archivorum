import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { PageWrapperComponent } from "../../../components/phone/page-wrapper/page-wrapper.component";

@Component({
  selector: 'app-curatio',
  standalone: true,
  imports: [
    RouterLink,
    RouterLinkActive,
    MatListModule,
    MatIconModule,
    PageWrapperComponent],
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
      title: 'anatomia',
      icon: 'accessibility_new',
      route: '/curatio/anatomia'
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
